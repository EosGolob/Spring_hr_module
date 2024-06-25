import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import UsersService from "../services/UsersService";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEnvelope, faLock } from '@fortawesome/free-solid-svg-icons';
// import '../auth/LoginPage.css';


function LoginPage() {
   const [email, setEmail] = useState('')
   const [password, setPassword] = useState('')
   const [error, setError] = useState('')
   const navigate = useNavigate();

   const handleSubmit = async (e) => {
      e.preventDefault();

      try {
         const userDate = await UsersService.login(email, password)
         console.log(userDate)
         if (userDate.token) {
            localStorage.setItem('token', userDate.token)
            localStorage.setItem('role', userDate.role)
            navigate('/process-Selection')
         } else {
            setError(userDate.message)
         }
      } catch (error) {
         console.log(error)
         setError(error.message)
         setTimeout(() => {
            setError('');
         }, 5000);
      }
   }

   return (
      /*
      <div className="auth-container d-flex justify-content-center align-items-center vh-100">
         <div className="col-lg-4 col-md-6 col-sm-8 bg-light p-4 rounded">
            <h1 className="text-center mb-4">LOGIN</h1>
            {error && <p className="error-message">{error}</p>}
            <form onSubmit={handleSubmit}>
               <div className="form-group mb-4">
               <div className="input-group">
                  <span className="input-group-text"><FontAwesomeIcon icon={faEnvelope} /></span>
                  <input type="email"
                   placeholder = "Enter your email"
                   value={email} 
                   onChange={(e) => setEmail(e.target.value)} />
                  </div>
               </div>
               <div className="form-group mb-4">
               <div className="input-group">
               <span className="input-group-text"><FontAwesomeIcon icon={faLock} /></span>
                  <input type="password" 
                   placeholder = "Enter your Password"
                   value={password} 
                   onChange={(e) => setPassword(e.target.value)} />
              
              </div>
               </div>
               <div className="text-center">
                  <button type="submit" className="btn btn-primary">Login</button>
               </div>
            </form>
         </div>
      </div>
   )
*/
      <div className="auth-container">
         <h2>Login</h2>
         {error && <p className="error-message">{error}</p>}
         <form onSubmit={handleSubmit}>
            <div className="form-group">
               <label>Email: </label>
               <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} />
            </div>
            <div className="form-group">
               <label>Password: </label>
               <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
            </div>
            <button type="submit">Login</button>
         </form>
      </div>
   )
}
export default LoginPage;