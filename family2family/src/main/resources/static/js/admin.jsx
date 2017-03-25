
class NavBarComponent extends React.Component {
    render() {
        return(
            <nav className="navbar navbar-default">
                <div className="container-fluid">
                    <ul className="nav navbar-nav">
                        <li className="active"><a href="#">Home</a></li>
                        <li><a href="#Page1">Page 1</a></li>
                        <li><a href="#Page2">Page 2</a></li>
                        <li><a href="#Page3">Page 3</a></li>
                    </ul>
                </div>
            </nav>
        )
    }
}

class TabBarComponent extends React.Component {
    render() {
        return(
            <ul className="nav nav-tabs">
                <li><a href="#">Users</a></li>
                <li><a href="#">Reference Tables</a></li>
            </ul>
        )
    }
}

class EditUserRow extends React.Component {
    constructor(props) {
        super(props);
        this.state = {userid:"", fname:"", lname:"", admin:{true}, activeUser:{false}};
    }

    handleChange(event) {
        this.setState({value: event.target.value});
    }

    sendFormData: function () {
    // Fetch form values.
    var formData = {
        userid: React.findDOMNode(this.props.userid).value,
        fname: React.findDOMNode(this.props.fname).value,
        lname: React.findDOMNode(this.props.lname).value

    };

    render() {
        return(
            <div class="editUserRow" className="editUserRow">
                <form className="form-horizontal">
                    <div className="form-group">
                        <label className="control-label col-sm-2" for="userid">User ID: </label>
                        <div className="col-sm-3">
                            <input type="text" className="form-control" name="userid" value={this.props.userid} onChange={this.handleChange}/>
                        </div>
                    </div>
                    <div className="form-group">
                        <label className="control-label col-sm-2" for="fname">First Name:</label>
                        <div className="col-sm-3">
                            <input type="text" className="form-control" name="fname" value={this.state.fname} onChange={this.handleChange}/>
                        </div>
                    </div>
                    <div className="form-group">
                        <label className="control-label col-sm-2" for="lname">Last Name: </label>
                        <div className="col-sm-3">
                            <input type="text" className="form-control" name="lname" value={this.state.lname} onChange={this.handleChange}/>
                        </div>
                    </div>
                    <div className="form-group">
                        <label className="control-label col-md-2" for="admin">Administrator: </label>
                        <div className="col-sm-3">
                            <div className="checkbox">
                                <input type="checkbox" name="admin" value={this.state.admin} onChange={this.handleChange}/>
                            </div>
                        </div>
                    </div>
                    <div className="form-group">
                        <label className="control-label col-md-2" for="admin">Active: </label>
                        <div className="col-sm-3">
                            <div className="checkbox">
                                <input type="checkbox" name="active" value={this.state.active} onChange={this.handleChange}/>
                            </div>
                        </div>
                    </div>
                    <div className="button-group">
                        <button type="submit" className="btn delete col-sm-1">Delete</button>
                        <button type="submit" className="btn col-sm-1">Reset</button>
                        <button type="submit" className="btn btn-primary col-sm-1">Save</button>
                    </div>
                </form>
            </div>
        )
    }
}

class AppContent extends React.Component {
    //TODO add routing or page state handling
    render() {
        return (
            <div>
                <NavBarComponent />
                <TabBarComponent/>
                <EditUserRow  userid="" />
            </div>
        );
    }
}

ReactDOM.render(<AppContent />, document.getElementById('appContent'));