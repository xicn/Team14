import React from 'react';
import './login.css';
import { useNavigate } from "react-router-dom";

export default function Login() {

    let navigate = useNavigate();

    function handleClick() {
        navigate("/home");
    }

return (
    <div>
    <meta charSet="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="google-signin-scope" content="profile email" />
    <meta name="google-signin-client_id" content="70477435980-hcoujshji22jhmmlqajnoop0i7l75453.apps.googleusercontent.com" />
    <link href="./loginstyle.css" rel="stylesheet" />
    <title>Login Page</title>
    <p>This is the login page, you can login to your account using the username and password bars and pressing the login button. If you do not have an account yet, just create one!</p>
    <form action="" method="POST" className="form">
        <section className="login">
        <label htmlFor="username"><b>Username:</b><br /></label>
        <input type="text" placeholder="Username" autofocus name="username" id="username" className="uspw" required />
        <br />
        <br />
        <label htmlFor="pw"><b>Password:</b><br /></label>
        <input type="password" placeholder="Password" name="pw" id="pw" className="uspw" required />
        <br /><br />
        <button type="submit" className="loginbutton" onClick={handleClick}>Login</button>
        </section>
    </form>
    <div id="like_button_container" />
    <br />
    </div>
    );
}