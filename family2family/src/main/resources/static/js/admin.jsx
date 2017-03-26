class User extends React.Component {
    render() {
        return(
            <div className="row">
                <div className="col-sm-3">{this.props.user.userId}</div>
                <div className="col-sm-3">{this.props.user.firstName + " " + this.props.user.lastName}</div>
                <div className="col-sm-3">
                    <input type="checkbox" name="admin" checked={this.props.user.admin} disabled={true}/>
                </div>
                <div className="col-sm-3">
                    <input type="checkbox" name="active" checked={this.props.user.active} disabled={true}/>
                </div>
            </div>
        )
    }
}

class UserTable extends React.Component{

    constructor(props) {
        super(props);
        this.state = {users: []};
    }

    componentDidMount() {
        $.getJSON('/internal-api/Users').then((data) => {
            this.setState({users: data._embedded.Users});
        })
    }

    render() {
        let users = this.state.users.map(user =>
            <User key={user.userId} user={user}/>
        );
        return (
            <div>
                <div className="row">
                    <div className="col-xs-3">
                        User Id
                    </div>
                    <div className="col-xs-3">
                        User Name
                    </div>
                    <div className="col-xs-3">
                        Administrator
                    </div>
                    <div className="col-xs-3">
                        Active
                    </div>
                </div>
                {users}
            </div>
        )
    }
}

class NavBarComponent extends React.Component {
    render() {
        return(
            <nav className="navbar navbar-default">
                <div className="container-fluid">
                    <ul className="nav navbar-nav">
                       <li><a href="">Users</a></li>
                       <li><a href="">Reference Tables</a></li>
                   </ul>
                </div>
            </nav>
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


    render() {
        return(
            <div className="editUserRow">
                <form className="form-horizontal">
                    <div className="form-group">
                        <label className="control-label col-sm-2" htmlFor="userid">User ID: </label>
                        <div className="col-sm-3">
                            <input type="text" className="form-control" name="userid" value={this.props.userid} onChange={this.handleChange}/>
                        </div>
                    </div>
                    <div className="form-group">
                        <label className="control-label col-sm-2" htmlFor="fname">First Name:</label>
                        <div className="col-sm-3">
                            <input type="text" className="form-control" name="fname" value={this.state.fname} onChange={this.handleChange}/>
                        </div>
                    </div>
                    <div className="form-group">
                        <label className="control-label col-sm-2" htmlFor="lname">Last Name: </label>
                        <div className="col-sm-3">
                            <input type="text" className="form-control" name="lname" value={this.state.lname} onChange={this.handleChange}/>
                        </div>
                    </div>
                    <div className="form-group">
                        <label className="control-label col-md-2" htmlFor="admin">Administrator: </label>
                        <div className="col-sm-3">
                            <div className="checkbox">
                                <input type="checkbox" name="admin" value={this.state.admin} onChange={this.handleChange}/>
                            </div>
                        </div>
                    </div>
                    <div className="form-group">
                        <label className="control-label col-md-2" htmlFor="active">Active: </label>
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
                <UserTable />
                <EditUserRow  userid="" />

            </div>
        );
    }
}

ReactDOM.render(<AppContent />, document.getElementById('appContent'));