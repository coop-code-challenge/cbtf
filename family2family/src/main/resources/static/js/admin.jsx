
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

class AppContent extends React.Component {
    //TODO add routing or page state handling
    render() {
        return (
            <div>
                <NavBarComponent />
            </div>
        );
    }
}

ReactDOM.render(<AppContent />, document.getElementById('appContent'));