import {
  Description,
  Edit,
  MailOutline,
  PermIdentity,
  Undo,
} from '@material-ui/icons';
import { Link, useParams } from 'react-router-dom';
import './group.css';
import { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import { Editor } from 'react-draft-wysiwyg';
import { EditorState } from 'draft-js';
import 'react-draft-wysiwyg/dist/react-draft-wysiwyg.css';
import GroupCard from '../../../components/groupCard/GroupCard';
import UserCard from '../../../components/userCard/UserCard';

export default function Group() {
  const navigate = useNavigate();
  const { groupId } = useParams();
  console.log(groupId);
  const [data, setData] = useState([]);
  const [change, setChange] = useState(true);

  useEffect(() => {
    let isMounted = true;
    axios('http://localhost:8080/api/v1/groups/getById/' + groupId).then(
      (result) => {
        if (isMounted) setData(result.data);
        console.log(result.data);
      }
    );
    return () => {
      isMounted = false;
    };
  }, []);

  const handleSubmit = (event) => {
    event.preventDefault();
    const name = event.target.elements.name.value;
    const description = event.target.elements.description.value;
    const membersOnly = event.target.elements.membersOnly.value;
    console.log(name, description, membersOnly);
    const GroupDTO = {
      groupID: groupId,
      name: name ? name : data.name,
      description: description ? description : data.description,
      membersOnly: membersOnly ? membersOnly : data.membersOnly,
    };

    console.log(GroupDTO);
    axios
      .put('http://localhost:8080/api/v1/groups/update', GroupDTO, {
        headers: {
          'Content-Type': 'application/json',
        },
      })
      .then(function (response) {
        console.log(response);
        setChange(!change);
        navigate({ pathname: '/groups' });
      })
      .catch(function (error) {
        console.log(error);
      });
  };
  return (
    <div className="user">
      <div className="userTitleContainer">
        <div className="titleContainer">
          <h1 className="userTitle">Edit Group</h1>
          <Link
            to="/groups"
            style={{ textDecoration: 'none', color: 'inherit' }}
          >
            <Undo className="undoBut" />
          </Link>
        </div>
        <Link to="/newGroup">
          <button className="userAddButton">Create</button>
        </Link>
      </div>
      <div className="userContainer">
        <div className="userShow">
          <div className="userShowTop">
            <img
              src="https://cdn.pixabay.com/photo/2016/11/14/17/39/group-1824145_1280.png"
              alt=""
              className="userShowImg"
            />
            <div className="userShowTopTitle">
              <span className="userShowUsername">{data.name}</span>
            </div>
          </div>
          <div className="userShowBottom">
            <span className="userShowTitle">Group Details</span>
            <div className="userShowInfo">
              <PermIdentity className="userShowIcon" />
              <span className="userShowInfoTitle">{data.groupID}</span>
            </div>

            <span className="userShowTitle">Description</span>

            <div className="userShowInfo">
              <Description className="userShowIcon" />
              <span className="userShowInfoTitle">
                {data.description == null ? 'Nothings here!' : data.description}
              </span>
            </div>

            <span className="userShowTitle">Members Only</span>

            <div className="userShowInfo">
              <Edit className="userShowIcon" />
              <span className="userShowInfoTitle">{data.membersOnly}</span>
            </div>
          </div>
        </div>
        <div className="userUpdate">
          <span className="userUpdateTitle">Edit</span>
          <form className="userUpdateForm" onSubmit={handleSubmit}>
            <div className="userUpdateLeft">
              <div className="userUpdateItem">
                <label>Group Name</label>
                <input
                  type="text"
                  placeholder="Class"
                  className="userUpdateInput"
                  name="name"
                />
              </div>
              <div className="userUpdateItem">
                <label>Description</label>
                <input
                  type="text"
                  placeholder="Describe group"
                  className="userUpdateInput"
                  name="description"
                />
              </div>
              <div className="userUpdateItem">
                <label>Members Only</label>
                <input
                  type="text"
                  placeholder="Describe members only"
                  className="userUpdateInput"
                  name="membersOnly"
                />
              </div>
            </div>
            <div className="userUpdateRight"></div>
            <button className="userUpdateButton">Update</button>
          </form>
        </div>
      </div>
      <div className="groupContainer">
        <span className="userUpdateTitle">Users</span>
        <Link to="/AddUserToGroup">
          <button className="userAddButton" style={{ marginLeft: '20px' }}>
            Add Users
          </button>
        </Link>
        <div className="cardsContainer">
          {data.users?.map((item, i) => {
            return (
              <UserCard
                key={i}
                link={item.userLink}
                name={item.userName}
                userId={item.userId}
                groupId={item.groupId}
                memberId={item.membershipID}
              />
            );
          })}
        </div>
      </div>
    </div>
  );
}
