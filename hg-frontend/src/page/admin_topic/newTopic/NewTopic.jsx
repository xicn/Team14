import './newTopic.css';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

export default function NewTopic() {
  const navigate = useNavigate();

  const handleSubmit = (event) => {
    event.preventDefault();
    const name = event.target.elements.name.value;
    const description = event.target.elements.description.value;
    console.log({ name, description });

    axios
      .post(
        'http://localhost:8080/api/v1/topics/createTopic',
        {
          name,
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
        navigate({ pathname: '/topics' });
      })
      .catch(function (error) {
        console.log(error);
      });
  };

  return (
    <div className="newUser">
      <h1 className="newUserTitle">New Topic</h1>
      <form className="newUserForm" onSubmit={handleSubmit}>
        <div className="newUserItem">
          <label>Title</label>
          <input type="text" placeholder="CS3141" name="name" />
        </div>
        <div className="newUserItem">
          <label>Description</label>
          <input
            type="text"
            placeholder="Description goes here!"
            name="description"
          />
        </div>
        <button className="newUserButton">Create</button>
      </form>
    </div>
  );
}
