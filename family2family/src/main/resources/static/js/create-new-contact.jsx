

class CreateNewContact extends React.Component {
    render() {
        return (
            <div>
                <MatchViewInfo matchInformation={this.props.matchInformation} />
            </div>
        );
    }
}

class MatchViewInfo extends React.Component {
    render() {
        return (
            <div>
                <input type="text" name="firstname" placeholder={this.props.matchInformation.firstName}/><br />
                <input type="text" name="lastname" placeholder={this.props.matchInformation.lastName}/><br />
                <input type="checkbox" id="Mentor" value="Mentor"/>
                <label htmlFor="Mentor">Mentor</label><br />
                <input type="checkbox" id="Mentee" value="Mentee"/>
                <label htmlFor="Mentor">Mentee</label><br />
                <input type="checkbox" id="DoNotContact" value="DoNotContact"/>
                <label htmlFor="Mentor">Do Not Contact</label><br />
                <label htmlFor="matchedwith">Matched With: </label>
                <input type="text" id="matchedwith" placeholder={this.props.matchInformation.firstName+" "+this.props.matchInformation.lastName}/><br />
                <label htmlFor="matcheddate">Matched Date: </label>
                <input type="text" id="matcheddate" placeholder=""/><br />
                <label htmlFor="matcheddate">Last Match Date: </label><br />
                <label htmlFor="matcheddate">Number of Times Matched: </label>
            </div>
        );
    }
}

var matchInformation = {
    firstName: "John",
    lastName: "Smith"
}

ReactDOM.render(<CreateNewContact matchInformation={matchInformation} />, document.getElementById('root'));