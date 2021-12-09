import axios from 'axios';

export interface User {
  // firstName: string | null;
  name: string | null;
  email: string | null;
  role: ROLE;
  img: string | null;
  token: string | null;
}

export enum ROLE {
  ADMIN = 'admin',
  USER = 'user',
}

export interface LoginRequest {
  email: string;
  password: string;
}

export interface SignupRequest {
  // firstName: string | null;
  fistName: string | null;
  lastName: string | null;
  email: string | null;
  password: string;
}

class CurrentUser implements User {
  constructor(
    // firstName: string | null,
    name: string | null,
    email: string | null,
    role: ROLE,
    img: string | null,
    token: string | null
  ) {
    // this.firstName = firstName;
    // this.lastName = lastName;
    this.name = name;
    this.email = email;
    this.role = role;
    this.img = img;
    this.token = token;
  }
  // firstName: string | null;
  // lastName: string | null;
  name: string | null;
  email: string | null;
  role: ROLE;
  img: string | null;
  token: string | null;
}

export function getCurrentUser(): User {
  let name: string | null = localStorage.getItem('name');
  // let lastName: string | null = localStorage.getItem('lastName');
  let email: string | null = localStorage.getItem('email');
  let role: ROLE =
    localStorage.getItem('role') === 'ROLE_ADMIN' ? ROLE.ADMIN : ROLE.USER;
  let img: string | null = localStorage.getItem('img');
  let token: string | null = localStorage.getItem('auth');

  const user: User = new CurrentUser(
    // firstName,
    // lastName,
    name,
    email,
    role,
    img,
    token
  );
  return user;
}

export function isAuthenticated(): boolean {
  return localStorage.getItem('isAuth') ? true : false;
}

export function loginRequest() {
  return (payload: LoginRequest) =>
    axios.post('http://localhost:8080/api/v1/auth/signin', payload);
}

export function setLocalUserStorage(
  name: string,
  // lastName: string,
  email: string,
  role: ROLE,
  img: string,
  token: string
) {
  localStorage.clear();
  // localStorage.setItem('firstName', ' ' && firstName);
  localStorage.setItem('name', name);
  localStorage.setItem('email', email);
  localStorage.setItem('role', role);
  localStorage.setItem('img', img);
  localStorage.setItem('auth', token);
  localStorage.setItem('isAuth', 'true');
}
