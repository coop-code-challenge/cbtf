class MatchMakerContent extends React.Component {

    constructor(props) {
        super(props);
        this.state = {textBox: '', isError: false, errorMessage: '', firstName: '', lastName: '', hasMatch: false};

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        this.setState({textBox: event.target.value});
    }

    handleSubmit(event){
        const parent = this;

        const currentUserInput = this.state.textBox;
        const url = '/api/users/' + currentUserInput + '/first-potential-mentor';
        $.getJSON(url).then((data) => {
            parent.setState({firstName: data.firstName, lastName: data.lastName, isError: false, hasMatch: true});
        })
            .fail(function() { parent.setState({isError: true, errorMessage: 'ERROR: user not found', hasMatch: false});});

    }

    render() {
        return (
            <div>
                <h3>Find a mentor for:</h3>
                <div>
                    <input type="text" placeholder="Email Address" onChange={this.handleChange}/>
                    <button onClick={this.handleSubmit}>Search</button>
                </div>
                <br />
                <span hidden={!this.state.isError}>{this.state.errorMessage}</span>
                <span hidden={!this.state.hasMatch}>{this.state.firstName} {this.state.lastName}</span>
            </div>

        );
    }
}

ReactDOM.render(<MatchMakerContent />, document.getElementById('root'));