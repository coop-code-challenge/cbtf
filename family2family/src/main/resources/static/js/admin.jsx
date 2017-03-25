class User extends React.Component {
    constructor(props) {
        super(props);

        this.state = {userid: "", username: "", adminchecked: {false}, activechecked: {false}};
    }

    render() {
        return(
            <div className="row" data-toggle="collapse">
                <div className="col-sm-3">{this.props.userid}</div>
                <div className="col-sm-3">{this.props.username}</div>
                <div className="col-sm-3">
                    <input type="checkbox" name="admin" checked={this.props.adminchecked} disabled={true}/>
                </div>
                <div className="col-sm-3">
                    <input type="checkbox" name="active" checked={this.props.activechecked} disabled={true}/>
                </div>
            </div>
        )
    }
}
class UserTable extends React.Component {
    render() {
        return(
            <div class="container">
                <div className="row">
                    <div className="col-sm-3 bold">User ID</div>
                    <div className="col-sm-3 bold">Name</div>
                    <div className="col-sm-3 bold">Administrator</div>
                    <div className="col-sm-3 bold">Active?</div>
                </div>
                <User userid="WADE123" username="Wade Iwata" adminchecked={false} activechecked={true} />
                <User userid="WADE123" username="Wade Iwata" adminchecked={false} activechecked={true} />
                <User userid="WADE123" username="Wade Iwata" adminchecked={false} activechecked={true} />
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

    render() {
        return(
            <div class="editUserRow" className="editUserRow">
                <form className="form-horizontal">
                    <div className="form-group">
                        <label className="control-label col-sm-2" for="userid">User ID: </label>
                        <div className="col-sm-3">
                            <input type="text" className="form-control" name="userid" value={this.props.userid}></input>
                        </div>
                    </div>
                    <div className="form-group">
                        <label className="control-label col-sm-2" for="fname">First Name:</label>
                        <div className="col-sm-3">
                            <input type="text" className="form-control" name="fname" value={this.state.fname}></input>
                        </div>
                    </div>
                    <div className="form-group">
                        <label className="control-label col-sm-2" for="lname">Last Name: </label>
                        <div className="col-sm-3">
                            <input type="text" className="form-control" name="lname" value={this.state.lname}></input>
                        </div>
                    </div>
                    <div className="form-group">
                        <label className="control-label col-md-2" for="admin">Administrator: </label>
                        <div className="col-sm-3">
                            <div className="checkbox">
                                <input type="checkbox" name="admin" value={this.state.admin}></input>
                            </div>
                        </div>
                    </div>
                    <div className="form-group">
                        <label className="control-label col-md-2" for="admin">Active: </label>
                        <div className="col-sm-3">
                            <div className="checkbox">
                                <input type="checkbox" name="admin" value={this.state.active}></input>
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
                <UserTable />
                <EditUserRow  userid="" />

            </div>
        );
    }
}

ReactDOM.render(<AppContent />, document.getElementById('appContent'));