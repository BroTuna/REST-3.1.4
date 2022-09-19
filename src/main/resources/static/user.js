const url = 'http://localhost:8080/api/user/'
let userInfo = document.querySelector('#UserInfo');
let userHeads = document.querySelector('#UserHeads')

fetch(url)
    .then(res => res.json())
    .then(data => {
        userHeads.innerHTML = `
                <span class="align-middle mr-1">${data.username}
                with roles: ${data.roles.map(role => role.name === 'ROLE_USER' ? ' USER' : ' ADMIN')} </span>
                `;
        userInfo.innerHTML = `
                                <td>${data.id}</td>
                                <td>${data.firstname}</td>
                                <td>${data.lastname}</td>
                                <td>${data.age}</td>
                                <td>${data.username}</td>
                                <td>${data.roles.map(role => role.name === 'ROLE_USER' ? 'USER' : 'ADMIN')}</td>
                                
`;})