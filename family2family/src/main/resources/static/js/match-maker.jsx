

class MatchMakerContent extends React.Component {

    constructor(props) {
        super(props);
        this.state = {textBox: '', isError: false, errorMessage: '', firstName: '', lastName: ''};

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        //console.log(event.target.value);
        this.setState({textBox: event.target.value});
    }

    handleSubmit(event){
        var parent = this;

        var textBox = this.state.textBox;
        var url = '/api/findmatch/' + textBox + '/';
        $.getJSON(url).then((data) => {
            parent.setState({firstName: data.firstName, lastName: data.lastName, isError: false});
            console.log(textBox);
        })
            .fail(function() { parent.setState({isError: true, errorMessage: 'ERROR: user not found'});});

    }

    render() {
        return (
            <div>
                <h3>Please enter the User ID of the mentee</h3>
                <form>
                    <input type="text" onChange={this.handleChange}/>
                    <button onClick={this.handleSubmit}>Search for a mentor</button>
                </form>
                <br />
                <span hidden={!this.state.isError}>{this.state.errorMessage}</span>
                <span hidden={this.state.isError}>{this.state.firstName} {this.state.lastName}</span>
            </div>

        );
    }
}

ReactDOM.render(<MatchMakerContent />, document.getElementById('root'));