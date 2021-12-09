import './users.css';
import { DataGrid } from '@material-ui/data-grid';
import { DeleteOutline } from '@material-ui/icons';
import { Link, useNavigate } from 'react-router-dom';
import { useState, useEffect } from 'react';
import axios from 'axios';
import { getHeaderWithOnlyJwtAuth } from '../../../util/request';

export default function Users() {
  const [data, setData] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    let isMounted = true;
    axios(
      'http://localhost:8080/api/v1/users/getAllUsers',
      getHeaderWithOnlyJwtAuth(localStorage.getItem('auth'))
    ).then((result) => {
      if (isMounted) setData(result.data);
      console.log(result.data);
    });
    return () => {
      isMounted = false;
    };
  }, []);

  const handleDelete = (id) => {
    setData(data.filter((item) => item.id !== id));
    axios
      .delete('http://localhost:8080/api/v1/users/deleteById/' + id)
      .then((result) => console.log(result));
  };

  const columns = [
    { field: 'id', headerName: 'ID', width: 300 },
    {
      field: 'link',
      headerName: 'User',
      width: 10,
      renderCell: (params) => {
        return (
          <div className="userListUser">
            <img className="userListImg" src={params.row.link} alt="" />
            {params.row.username}
          </div>
        );
      },
    },
    { field: 'firstName', headerName: 'First Name', width: 150 },
    { field: 'lastName', headerName: 'First Name', width: 150 },

    { field: 'email', headerName: 'Email', width: 200 },
    {
      field: 'description',
      headerName: 'Description',
      width: 160,
    },
    {
      field: 'action',
      headerName: 'Action',
      width: 150,
      renderCell: (params) => {
        return (
          <>
            <Link to={'/user/' + params.row.id}>
              <button className="userListEdit">Edit</button>
            </Link>
            <DeleteOutline
              className="userListDelete"
              onClick={() => handleDelete(params.row.id)}
            />
          </>
        );
      },
    },
  ];

  return (
    <div className="users">
      <div className="userTitleContainer">
        <h1 className="userTitle">User</h1>
        <Link to="/newUser">
          <button className="userAddButton">Create</button>
        </Link>
      </div>
      {/* <div className="headline">
        <h1>Users</h1>
        <Link to="/newUser">
          <button
            className="newUserButton"
            style={{ marginTop: 0, marginLeft: 20, padding: '7px 10px' }}
          >
            Create
          </button>
        </Link>
        <div className="inBetween"></div>
      </div> */}

      <DataGrid
        rows={data}
        disableSelectionOnClick
        columns={columns}
        pageSize={8}
        checkboxSelection
        style={{ color: 'black', backgroundColor: 'white' }}
      />
    </div>
  );
}
