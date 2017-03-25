class Contact extends React.Component {
    render() {
        return (
            <div>
                <ContactHeader />
                <ContactTable/>
            </div>
        );
    }
}

class ContactHeader extends React.Component {
    render() {
        return (
            <div>
                <p>
                    <h1>Contact</h1>
                </p>
            </div>
        );
    }
}
class ContactTable extends React.Component {
    /*componentDidMount() {
     $.getJSON('/internal-api/Contact/1').then((data) => {
     this.setState({contact: data});
     });
     }
     */
    render() {
        return (
            <table>
                <tbody>
                <tr>Daytime Phone Number: {this.props.contactInfo.primaryPhoneNumber}</tr>
                <tr>Other Phone Number: {this.props.contactInfo.secondaryPhoneNumber}</tr>
                <tr>City: {this.props.contactInfo.city}</tr>
                <tr>State:{this.props.contactInfo.state}</tr>
                <tr>Email: {this.props.contactInfo.primaryEmail}</tr>
                <tr>Alternate Email: {this.props.contactInfo.secondaryEmail}</tr>
                </tbody>
            </table>
        )
    }
}

var notesInfo = {
    primaryPhoneNumber: "",
    secondaryPhoneNumber: "",
    city: "",
    state: "",
    primaryEmail: "",
    secondaryEmail: ""
};

ReactDOM.render(<Contact />, document.getElementById('root'));