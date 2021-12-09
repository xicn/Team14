const { default: axios } = require('axios');

let payload = {
  email: 'admin@mtu.edu',
  password: '2000127',
};

let signup = {
  firstName: 'User',
  lastName: 'Normal',
  email: 'usernormal@gmail.com',
  password: '123456P@ssw0rd',
  role: [''],
};

let groupReq = {
  name: 'Group 1',
  topicID: '3dd9ccfa-26c0-472c-bce7-a6d7cbc68f15',
  description: 'This is a test run!',
};
// axios
//   .get('http://localhost:8080/api/v1/self/user', {
//     headers: {
//       Authorization: `Bearer ${'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBZG1pbiIsImlhdCI6MTYzODkyMTg0NiwiZXhwIjoxNjM4OTU3ODQ2fQ.WCHDpUsFWhtMHTcS8FkK4p63pOfsFLTUWHq-o56JLTiIdW72aVdpLDY1OHGOzbUNdNjehBsPsL38qpbT-s06Ew'}`,
//     },
//   })
//   .then((res) => console.log(res))
//   .catch((err) => console.log(err));

// axios
//   .post('http://localhost:8080/api/v1/auth/signin', payload)
//   .then((res) => console.log(res))
//   .catch((err) => console.log(err));

axios
  .post('http://localhost:8080/api/v1/auth/signup', signup)
  .then((res) => console.log(res))
  .catch((err) => console.log(err));

// axios
//   .get('http://localhost:8080/api/v1/users/getUser', {
//     headers: {
//       Authorization: `Bearer ${'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBtdHUuZWR1IiwiaWF0IjoxNjM4OTIzNDg3LCJleHAiOjE2Mzg5NTk0ODd9.toLH9HgRl_rPZBouwQvCUF11-RKM1iv1gwiY8yzAocq8PE017ncip5IKqxH0UYn7M_hjCQFlCZq_C3OVaikhxA'}`,
//     },
//   })
//   .then((res) => console.log(res))
//   .catch((err) => console.log(err));

// {headers: {
//   Authorization: `Bearer ${'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ4aWFvamllY0BnbWFpbC5jb20iLCJleHAiOjE2Mzg5NDc3NTMsImlhdCI6MTYzODkxMTc1M30.fBKe2OvKN0792Qo6jE0dzEdzoRCv5btppTxjyHXVvOE'}`,
// }
