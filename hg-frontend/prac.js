const { default: axios } = require('axios');
const { token } = require('./jtoken');
let group = {
  name: 'HelloWorld!',
  description: 'For testing purppose only!',
  topicID: '680253c0-f5d6-4dc3-bfd8-d84dc3e99ef3',
};

let member = {
  groupId: '51693262-4330-43e5-a4f8-dbc711d30fb7',
  userId: 'a628b3cf-1a8e-4907-a0b0-6c4d74750a71',
};

let user = {
  userName: 'xiaojiec@gmail.com',
  password: 'hello',
};

// axios
//   .post('http://localhost:8080/authenticate', user)
//   .then((res) => console.log(res))
//   .catch((err) => console.log(err));

let user1 = {
  firstName: 'Xiaojie',
  lastName: 'Chen',
  email: 'xiaojiec@mtu.edu',
  password: '2000127',
  role: ['mod', 'user'],
};

// let user2 = {
//   firstName: 'Xiaojie',
//   lastName: 'Chen',
//   email: 'xiaojiec@mtu.edu',
//   password: '2000127',
//   role: ['mod','user'],
// };

// let user3 = {
//   firstName: 'Xiaojie',
//   lastName: 'Chen',
//   email: 'xiaojiec@mtu.edu',
//   password: '2000127',
//   role: ['mod','user'],
// };

axios
  .post('http://localhost:8080/api/v1/auth/signup', user1)
  .then((res) => console.log(res))
  .catch((err) => console.log(err));

// {headers: {
//   Authorization: `Bearer ${'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ4aWFvamllY0BnbWFpbC5jb20iLCJleHAiOjE2Mzg5NDc3NTMsImlhdCI6MTYzODkxMTc1M30.fBKe2OvKN0792Qo6jE0dzEdzoRCv5btppTxjyHXVvOE'}`,
// }
