class PhysicalChallenge extends React.Component {
    render() {
        const challenge = this.props.challenges;

        const items = challenge.map((challenges) =>
            <div key = {challenges.description}>
                <input type = "checkbox" value = {challenges.description}  />
                <span> {challenges.description}</span>
            </div>
        );

        return(
            <form>{items}</form>
        )
    }

}
var challenges = [
    {
        description: "Allergic Reaction - Medication",
        active: true,
        _links: {
            self: {
                href: "http://localhost:8080/internal-api/Subcategory/1"
            },
            subcategory: {
                href: "http://localhost:8080/internal-api/Subcategory/1"
            },
            category: {
                href: "http://localhost:8080/internal-api/Subcategory/1/category"
            }
        }
    },
    {
        description: "Brain Hemorrhage",
        active: true,
        _links: {
            self: {
                href: "http://localhost:8080/internal-api/Subcategory/10"
            },
            subcategory: {
                href: "http://localhost:8080/internal-api/Subcategory/10"
            },
            category: {
                href: "http://localhost:8080/internal-api/Subcategory/10/category"
            }
        }
    },
    {
        description: "Amputation",
        active: true,
        _links: {
            self: {
                href: "http://localhost:8080/internal-api/Subcategory/93"
            },
            subcategory: {
                href: "http://localhost:8080/internal-api/Subcategory/93"
            },
            category: {
                href: "http://localhost:8080/internal-api/Subcategory/93/category"
            }
        }
    },
    {
        description: "Anesthesia",
        active: true,
        _links: {
            self: {
                href: "http://localhost:8080/internal-api/Subcategory/94"
            },
            subcategory: {
                href: "http://localhost:8080/internal-api/Subcategory/94"
            },
            category: {
                href: "http://localhost:8080/internal-api/Subcategory/94/category"
            }
        }
    },
    {
        description: "Chemotherapy",
        active: true,
        _links: {
            self: {
                href: "http://localhost:8080/internal-api/Subcategory/95"
            },
            subcategory: {
                href: "http://localhost:8080/internal-api/Subcategory/95"
            },
            category: {
                href: "http://localhost:8080/internal-api/Subcategory/95/category"
            }
        }
    },
    {
        description: "Chemotherapy - Cisplatin",
        active: true,
        _links: {
            self: {
                href: "http://localhost:8080/internal-api/Subcategory/96"
            },
            subcategory: {
                href: "http://localhost:8080/internal-api/Subcategory/96"
            },
            category: {
                href: "http://localhost:8080/internal-api/Subcategory/96/category"
            }
        }
    },
    {
        description: "Chemotherapy - Oral",
        active: true,
        _links: {
            self: {
                href: "http://localhost:8080/internal-api/Subcategory/97"
            },
            subcategory: {
                href: "http://localhost:8080/internal-api/Subcategory/97"
            },
            category: {
                href: "http://localhost:8080/internal-api/Subcategory/97/category"
            }
        }
    },
    {
        description: "Chemotherapy - Vincistine",
        active: true,
        _links: {
            self: {
                href: "http://localhost:8080/internal-api/Subcategory/98"
            },
            subcategory: {
                href: "http://localhost:8080/internal-api/Subcategory/98"
            },
            category: {
                href: "http://localhost:8080/internal-api/Subcategory/98/category"
            }
        }
    }
];

//ReactDOM.render(<PhysicalChallenge challenges={challenges} />, document.getElementById('root'));