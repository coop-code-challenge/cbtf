/**
 * Created by heinhtetzaw on 3/25/17.
 */

/*
    id's for clicks, all are IDs so #

    contact-entry
    find-a-mentor
    admin-settings
 l  logout-button

 */

class FooterComponent extends React.Component {


    render() {
        return(
            <div id="footer">
                <ul id="footer-links">
                    <li><a href="#">Contact Entry</a></li>
                    <li><a href="#">Find a Member</a></li>
                    <li><a href="#">Admin Settings</a></li>
                    <li><a href="/logout">Admin Logout</a></li>
                </ul>
            </div>
        )
    }
}


ReactDOM.render(<FooterComponent />, document.getElementById('mainFooter'));
