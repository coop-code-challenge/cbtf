class ChildData extends React.Component {
    constructor(props) {
        super(props);

        this.state = {info: []};
    }
    componentWillMount() {
        $.getJSON("/internal-api/MentorMentee/1%7C3/mentor").then((data) => {
            this.setState({info: data});
        });
    }
}

class MatchTableInfo extends React.Component {
    /*constructor(props) {
     super(props);

     this.state = {mentor: [],
     mentee: []};
     }
     }

     Mentor-Mentee request for timeMatched:
     /internal-api/MentorMentee/1%7C3

     Mentor request for user Info:
     /internal-api/MentorMentee/1%7C3/mentor

     Mentee request for mentee info:
     /internal-api/MentorMentee/1%7C3/mentee
     */

    render(){
        return(
            <div>
                <table>
                    <tr>
                        <td>Name: </td>
                        <td>{this.prop.mentee.name}</td>
                    </tr>
                    <tr>
                        <td>Status</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Matched With: </td>
                        <td>{this.prop.mentor.name}</td>
                    </tr>
                    <tr>
                        <td>Date Matched: </td>
                        <td>{this.prop.date.dateMatched}</td>
                    </tr>
                    <tr>
                        <td>Last Matched: </td>
                        <td>{this.prop.date.lastMatched}</td>
                    </tr>
                    <tr>
                        <td>Number of Matches Made: </td>
                    </tr>
                </table>
            </div>
        );
    }
}

class MatchTableHeader extends React.Component {
    render(){
        return(
            <h1>Match Information</h1>
        );
    }
}

class MatchInformation extends React.Component {

    render() {
        return (
            <div>
                <MatchTableHeader />
                <MatchTableInfo />
            </div>
        );
    }
}

/*var bootStrap = {
 firstName: "John",
 lastName: "Smith",
 mentor: true,
 mentee: false,
 doNotContact: false,
 primaryPhoneNumber: "8009999999",
 primaryPhoneNumberVisibleToMatch: true,
 secondaryPhoneNumber: null,
 secondaryPhoneNumberVisibleToMatch: false,
 city: "St. Louis",
 state: "MO",
 primaryEmail: "work@pls",
 primaryEmailVisibleToMatch: true,
 secondaryEmail: null,
 secondaryEmailVisibleToMatch: false,
 contactNote: "I can be reached by email or SMS.",
 adminNote: "Great feedback from prior matches.",
 _links: {
 self: {
 href: "http://localhost:8080/internal-api/Contact/1"
 },
 contact: {
 href: "http://localhost:8080/internal-api/Contact/1"
 },
 children: {
 href: "http://localhost:8080/internal-api/Contact/1/children"
 },
 mentees: {
 href: "http://localhost:8080/internal-api/Contact/1/mentees"
 },
 mentors: {
 href: "http://localhost:8080/internal-api/Contact/1/mentors"
 }
 }
 }*/

ReactDOM.render(<MatchInformation />, document.getElementById('root'));