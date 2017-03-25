class AlreadySignedIn extends React.Component {
    constructor(props) {
        super(props);

        this.state = {person: []};
    }

    componentWillMount() {
        $.getJSON('/api/user').then((data) => {
            this.setState({person: data});
        });
    }

    render() {
        return(
            <div>
                <span>Congrats {this.state.person.givenName}, you are a Mentor/Mentee.</span>
            </div>
        );
    }
}

class AlertComponent extends React.Component{
    render() {
        return (
            <div>
                <h3>The will be the date of the alert</h3>
                <p>
                    this will be the message of the alert.
                </p>
            </div>
        )
    }
}

class MatchContactComponent extends React.Component{


    render(){

        return (
            <div className="componentBox">
                <div className="MatchContact">
                    <h3>My Match's Contact Information</h3>
                    <ul>
                        <ul >Daytime Phone Number : {this.props.dayPhoneNumber}</ul>
                        <ul >Other Phone Number : {this.props.otherPhoneNumber}</ul>
                        <ul >Email : {this.props.email}</ul>
                        <ul >Alternative Email : {this.props.altEmail}</ul>
                        <ul >Location : {this.props.location}</ul>
                    </ul>
                </div>
            </div>
        )
    }
}

class Notes extends React.Component{
    render(){
        return(
            <div className="componentBox">
            <div>
                <p>
                    My Notes:
                </p>
                <textarea rows="6" cols="50">
                </textarea>
            </div>
        </div>);
    }
}
class AppContent extends React.Component {
    //TODO add routing or page state handling
    render() {
        return (
            <div>
                <AlreadySignedIn />
                <table className="rowOne">
                    <tr>
                        <td><MatchContactComponent dayPhoneNumber="123456789" otherPhoneNumber="987654321" email="something@gmail.com" altEmail="somethingelse@gmail.com" location="here.exe" /></td>
                        <td><Notes /></td>
                    </tr>
                </table>
            </div>
        );
    }
}


ReactDOM.render(<AppContent />, document.getElementById('appContent'));