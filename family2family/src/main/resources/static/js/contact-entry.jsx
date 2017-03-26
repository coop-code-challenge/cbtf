


class ChildsViewInfo extends React.Component {
    render() {
        return (
            <div>
                <span>First Name : {this.props.child.first}</span><br />
                <span>Child's Diagnosis : {this.props.child.childDiagnosis}</span><br />
                <span>Date of Birth : {this.props.child.dateOfBirth}</span><br />
                <span>Age Of Diagnosis : {this.props.childDiagnosis.ageOfDiagnosis}</span><br />
                <span>Current Age : {this.props.child.currentAge}</span><br />
                <span>Bereaved : {this.props.child.bereaved ? 'YES' : 'NO'}</span>
            </div>
        );
    }
}

class ChildsInfo extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            child: {},
            childDiagnosis: {}
        };
    }

    componentDidMount() {
        $.getJSON('/internal-api/Child/1').then((data) => {
            console.log(data);
            this.setState({child: data});
        });
        $.getJSON('/internal-api/Child/1/diagnoses').then((data) => {
          this.setState({childDiagnosis : data});
        });

    }
    render() {
        return (
            <div>
                <h1>{this.props.title}</h1>
                <ChildsViewInfo child={this.state.child} childDiagnosis={this.state.childDiagnosis} />
            </div>
        );
    }
}


ReactDOM.render(<ChildsInfo title="Childs Information" />, document.getElementById('root'));