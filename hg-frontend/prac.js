const { default: axios } = require('axios');
let group = {
  name: 'HelloWorld!',
  description: 'For testing purppose only!',
  topicID: '680253c0-f5d6-4dc3-bfd8-d84dc3e99ef3',
};

let member = {
  groupId: '51693262-4330-43e5-a4f8-dbc711d30fb7',
  userId: 'a628b3cf-1a8e-4907-a0b0-6c4d74750a71',
};
axios
  .post('http://localhost:8080/api/v1/users/addToGroup', member)
  .then((res) => console.log(res));
