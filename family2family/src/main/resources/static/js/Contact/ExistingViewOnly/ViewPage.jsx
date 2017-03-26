class ViewPage extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            contact: {}
        };
    }

    componentWillMount() {
        const id = this.props.contactId || 1;
        const url = '/internal-api/Contact/' + id;
        $.getJSON(url).then(data => {
            this.setState({ contact: data });
        });
    }

    render() {
        const { contact } = this.state;
        if (Object.keys(contact).length === 0) {
            return (
                <div className="container">
                    <InfoCard title="Contact Information" />
                </div>
            );
        }
        const styles = {
            label: {
                marginRight: '8px'
            }
        };
        return (
            <div className="container">
                <InfoCard title="Contact Information">
                    <p><label style={styles.label}>Daytime Phone Number:</label>{contact.primaryPhoneNumber}</p>
                    <p><label style={styles.label}>Other Phone Number:</label>{contact.secondaryPhoneNumber}</p>
                    <p><label style={styles.label}>City:</label>{contact.city}</p>
                    <p><label style={styles.label}>State:</label>{contact.state}</p>
                    <p><label style={styles.label}>Email:</label>{contact.primaryEmail}</p>
                    <p><label style={styles.label}>Alternate Email:</label>{contact.secondaryEmail}</p>
                </InfoCard>
            </div>
        );
    }
}

class InfoCard extends React.Component {
    render() {
        return (
            <div className="panel panel-primary">
                <div className="panel-heading">
                    <h3 className="panel-title">{this.props.title}</h3>
                </div>
                <div className="panel-body">
                    {this.props.children}
                </div>
            </div>
        );
    }
}
ReactDOM.render(<ViewPage />, document.getElementById('root'));