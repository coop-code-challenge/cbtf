
class MatchViewInfo extends React.Component {
    render() {
        return (
            <div>
                <input type="text" name="firstname" placeholder={this.props.matchinfo.firstName}/><br />
                <input type="text" name="lastname" placeholder={this.props.matchinfo.lastName}/><br />
                <input type="checkbox" id="Mentor" value="Mentor"/>
                <label for="Mentor">Mentor</label><br />
                <input type="checkbox" id="Mentee" value="Mentee"/>
                <label for="Mentor">Mentee</label><br />
                <input type="checkbox" id="DoNotContact" value="DoNotContact"/>
                <label for="Mentor">Do Not Contact</label><br />
                <label for="matchedwith">Matched With: </label>
                <input type="text" id="matchedwith" placeholder={this.props.matchinfo.firstName+" "+this.props.matchinfo.lastName}/><br />
                <label for="matcheddate">Matched Date: </label>
                <input type="text" id="matcheddate" placeholder=""/><br />
                <label for="matcheddate">Last Match Date: </label><br />
                <label for="matcheddate">Number of Times Matched: </label>
            </div>
        );
    }
}

class MatchInfo extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            matchinfo: {}
        };
    }

    componentDidMount() {
        $.getJSON('/internal-api/Contact/1').then((data) => {
            console.log(data);
            this.setState({matchinfo: data});
        });
    }


    render() {
        return (
            <div>
                <h1>{this.props.title}</h1>
                <MatchViewInfo matchinfo={this.state.matchinfo} />
            </div>
        );
    }
}

ReactDOM.render(<MatchInfo title="Match Information" />, document.getElementById('root1'));