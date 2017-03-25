
class NavBarComponent extends React.Component {
    render() {
        return(
            <nav className="navbar navbar-default">
                <div className="container-fluid">
                   <h1>Admin</h1>
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