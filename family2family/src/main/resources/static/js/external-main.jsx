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
            <div className="contact-information-box">
                    <div className="component-box-title">My Match's Contact Information</div>
                    <ul>
                        <ul >Daytime Phone Number : {this.props.dayPhoneNumber}</ul>
                        <ul >Other Phone Number : {this.props.otherPhoneNumber}</ul>
                        <ul >Email : {this.props.email}</ul>
                        <ul >Alternative Email : {this.props.altEmail}</ul>
                        <ul >Location : {this.props.location}</ul>
                    </ul>
            </div>
        )
    }
}

class Notes extends React.Component{
    render(){
        return(
            <div className="note-box">
                <div className="component-box-title">
                    My Notes
                </div>
                <textarea rows="6" cols="50" className="notes-textarea">
                </textarea>
            </div>
        );
    }
}

class Phone_Information extends React.Component{
    render(){
        return(
            <div className="information-box">
                <div className="component-box-title">
                    My Contact Information:
                </div>
                <table>
                    <tr>
                        <td>
                            Daytime Phone Number:
                        </td>
                        <td>
                            <input type ="text">
                            </input>
                        </td>
                        <td>
                            <input type ="checkbox">
                            </input>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Other Phone Number:
                        </td>
                        <td>
                            <input type ="text">
                            </input>
                        </td>
                        <td>
                            <input type ="checkbox">
                            </input>
                        </td>
                    </tr>
                    <tr>
                        <td>
                        </td>
                        <td>
                            <input type ="text" placeholder="City">
                            </input>
                        </td>
                    </tr>
                    <tr>
                        <td>
                        </td>
                        <td>
                            <input type ="text" placeholder="State">
                            </input>
                        </td>
                    </tr>
                </table>
            </div>
        )
    }
}
class Contact_Information extends React.Component{
    render(){
        return(
            <div className="information-box">
                <div className="component-box-title">
                    Emails:
                </div>
                <table>
                    <tr>
                        <td>
                            Primary Email:
                            </td>
                        <td>
                            <input type ="text">
                            </input>
                        </td>
                        <td>
                            <input type ="checkbox">
                            </input>
                    Visible to match
                        </td>
                    </tr>
                    <tr>
                        <td>
                    Secondary Email:
                        </td>
                        <td>
                    <input type ="text">
                    </input>
                        </td>
                        <td>
                    <input type ="checkbox">
                    </input>
                            Visible to match
                        </td>
                    </tr>

                </table>
            </div>
        )

    }
}
class AppContent extends React.Component {
    //TODO add routing or page state handling
    render() {
        return (
            <div>
                <AlreadySignedIn />
                <div className="row">
                    <div className="col-sm-12 col-md-6 col-lg-6">
                        <div className="component-box" >
                            <MatchContactComponent dayPhoneNumber="123456789" otherPhoneNumber="987654321" email="something@gmail.com" altEmail="somethingelse@gmail.com" location="here.exe" />
                        </div>
                    </div>

                    <div className="col-sm-12 col-md-6 col-lg-6">
                        <div className="component-box">
                            <Notes />
                        </div>
                    </div>
                </div>
                <div className="row">
                    <div className="col-sm-12 col-md-6 col-lg-6">
                        <div className="component-box" >
                            <Phone_Information />
                        </div>
                    </div>
                    <div className="col-sm-12 col-md-6 col-lg-6">
                        <div className="component-box" >
                            <Contact_Information />
                        </div>
                   </div>
                </div>
            </div>
        );
    }
}


ReactDOM.render(<AppContent />, document.getElementById('appContent'));