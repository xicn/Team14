const { default: axios } = require('axios');

let str = `Accounting
Air Force ROTC
Army ROTC
Art
Biomedical Engineering
Biological Sciences
Business
Civil & Environmental Engrg
Chemistry
Chemical Engineering
Construction Management
Computer Science
Economics
Education
Electrical & Computer Engrg
Electrical Engrg Technology
Engineering Fundamentals
Enterprise
Finance
Forest Resources & Env Science
Geolog. & Mining Engrg & Sci.
Pavlis Honors
Humanities
Kinesiology & Integrative Phys
Mathematical Sciences
Mechanical Eng. - Engrg. Mech.
Mechanical Engrg Technology
Management
Management Information Systems
Marketing
Materials Sci. & Engineering
Music
Operations & Supply Chain Mgmt
Physical Education
Physics
Psychology
Sciences and Arts
Systems Admin. Technology
Sound
Social Sciences
Surveying
Theatre
University Wide`;

let strA = str.split('\n');
let lis = [];

for (const iterator of strA) {
  lis.push({
    name: iterator.trim(),
    description: 'This is ' + iterator.trim() + ' related topic.',
  });
}

let prac = {
  name: 'University Wide',
  description: 'This is University Wide related topic.',
};

axios
  .post('http://localhost:8080/api/v1/topics/createTopicList', lis, {
    headers: {
      Authorization: `Bearer ${'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBtdHUuZWR1IiwiaWF0IjoxNjM4OTcwMTA0LCJleHAiOjE2MzkwMDYxMDR9.n4jiwEX551TP_LRVaS93pNGZBwRJRYsRN2aDINUibAYcVNauKDElo59ZRDDg5W5PVtPZ4q2_3-Jd53_JJIkCAw'}`,
    },
  })
  .then((res) => console.log(res))
  .catch((err) => console.log(err));
