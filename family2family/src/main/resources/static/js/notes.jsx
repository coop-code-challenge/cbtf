class Notes extends React.Component {
    render() {
        return (
            <div>
                <NotesHeader/>
                <NotesTable notesInfo={this.props.notesInfo}/>
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
                    <tbody>
                    <tr>
                        <td> Administrator Notes  </td>
                        <td> Mentor/Mentee's Notes </td>
                    </tr>
                    <tr>
                        <td>{this.props.notesInfo.adminNote}</td>
                        <td>{this.props.notesInfo.contactNote}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        );
    }
}

var notesInfo = {
    adminNote:" Great mentee feedback ",
    contactNote:" Need to change address "
};

ReactDOM.render(<Notes notesInfo={notesInfo} />, document.getElementById('root'));
