class Notes extends React.Component {
    render() {
        return (
            <div>
                <NotesHeader/>
                <NotesTable/>
            </div>
        );
    }
}

class NotesHeader extends React.Component {
    render() {
        return (
            <div>
                <h1> Notes</h1>
            </div>
        );
    }
}

class NotesTable extends React.Component {
    /*componentDidMount() {
     $.getJSON('/internal-api/Contact/1').then((data) => {
     this.setState({contact: data});
     });
     }*/
    render() {
        return (
            <div>
                <table>
                    <body>
                    <tr>
                        <td>Administrator Notes </td>
                        <td>Mentor/Mentee's Notes</td>
                    </tr>
                    <tr>
                        <td>{this.props.notesInfo.adminNote}</td>
                        <td>{this.props.notesInfo.contactNote}</td>
                    </tr>
                    </body>
                </table>
            </div>
        );
    }
}

var notesInfo = {
    adminNote: "",
    contactNote: ""
};

ReactDOM.render(<Notes />, document.getElementById('root'));
