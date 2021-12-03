import './newUser.css';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

export default function NewUser() {
  const navigate = useNavigate();
  // const [firstName, setFirstName] = useState();
  // const [lastName, setLastName] = useState();
  // const [email, setEmail] = useState();
  // const [description, setDescription] = useState();

  const handleSubmit = (event) => {
    event.preventDefault();
    const firstName = event.target.elements.firstName.value;
    const lastName = event.target.elements.lastName.value;
    const email = event.target.elements.email.value;
    const description = event.target.elements.description.value;

    axios
      .post(
        'http://localhost:8080/api/v1/users/createUser',
        {
          firstName,
          lastName,
          email,
          description,
        },
        {
          headers: {
            'Content-Type': 'application/json',
          },
        }
      )
      .then(function (response) {
        console.log(response);
        navigate({ pathname: '/users' });
      })
      .catch(function (error) {
        console.log(error);
      });
  };

  return (
    <div className="newUser">
      <h1 className="newUserTitle">New User</h1>
      <form
        className="newUserForm"
        // method="post"
        // action="http://localhost:8080/api/v1/new"
        onSubmit={handleSubmit}
      >
        <div className="newUserItem">
          <label>First Name</label>
          <input type="text" placeholder="john" name="firstName" />
        </div>
        <div className="newUserItem">
          <label>Last Name</label>
          <input type="text" placeholder="John Smith" name="lastName" />
        </div>
        <div className="newUserItem">
          <label>Email</label>
          <input type="email" placeholder="john@gmail.com" name="email" />
        </div>
        <div className="newUserItem">
          <label>Description</label>
          <input type="text" placeholder="John Smith" name="description" />
        </div>
        <button className="newUserButton">Create</button>
      </form>
    </div>
  );
}
