class Contact extends React.Component {
    render() {
        return (
            <div>
                <ContactHeader />
                <ContactTable contactInfo={this.props.contactInfo}/>
            </div>
        );
    }
}

class ContactHeader extends React.Component {
    render() {
        return (
            <div>
                    <h1>Contact</h1>
            </div>
        );
    }
}
class ContactTable extends React.Component {
    /*
     '/internal-api/Contact/1'
     */
    render() {
        return (
            <table>
                <tbody>
                <tr>Daytime Phone Number:  {this.props.contactInfo.primaryPhoneNumber}</tr>
                <tr>Other Phone Number:  {this.props.contactInfo.secondaryPhoneNumber}</tr>
                <tr>City:  {this.props.contactInfo.city}</tr>
                <tr>State: {this.props.contactInfo.state}</tr>
                <tr>Email:  {this.props.contactInfo.primaryEmail}</tr>
                <tr>Alternate Email:  {this.props.contactInfo.secondaryEmail}</tr>
                </tbody>
            </table>
        )
    }
}

var contactInfo = {
    primaryPhoneNumber: "314-920-8113",
    secondaryPhoneNumber: "",
    city: "Wentzville",
    state: "MO",
    primaryEmail: "nisc@nisc.com",
    secondaryEmail: ""
};

ReactDOM.render(<Contact contactInfo={contactInfo} />, document.getElementById('root'));