class MatchContactComponent extends React.Component{
    render(){

        return (
            <div className="contact-information-box">
                    <div className="component-box-title">My Match's Contact Information</div>
                    <ul>
                        <ul >Daytime Phone Number : {this.props.dayPhoneNumber}</ul>
                        <ul >Other Phone Number : {this.props.otherPhoneNumber}</ul>
                        <ul >Email : {this.props.email}</ul>
                        <ul >Alternative Email : {this.props.altEmail}</ul>
                        <ul >Location : {this.props.location}</ul>
                    </ul>
            </div>
        )
    }
}

class Notes extends React.Component{
    render(){
        return(
            <div className="note-box">
                <div className="component-box-title">
                    My Notes
                </div>
                <textarea rows="6" cols="50" className="notes-textarea">
                </textarea>
            </div>
        );
    }
}

class AppContent extends React.Component {
    //TODO add routing or page state handling
    render() {
        return (
            <div>
                <div className="row-one row">
                    <div className="col-sm-12 col-md-6 col-lg-6">
                        <div className="component-box" >
                            <div className="componentIcon">
                                <i className="fa fa-user-circle-o fa-stack-1x fa-inverse" style={{fontSize: 2.5 + 'em'}} aria-hidden="true"></i>
                            </div>
                            <MatchContactComponent dayPhoneNumber="123456789" otherPhoneNumber="987654321" email="something@gmail.com" altEmail="somethingelse@gmail.com" location="here.exe" />
                        </div>
                    </div>

                    <div className="col-sm-12 col-md-6 col-lg-6">
                        <div className="component-box">
                            <div className="componentIcon"><i className="fa fa-pencil-square fa-3x fa-inverse" aria-hidden="true"></i></div>
                            <Notes/>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}


ReactDOM.render(<AppContent />, document.getElementById('appContent'));