import React from 'react';
import { Link } from 'react-router-dom';
import UsersService from '../services/UsersService';

function Navbar() {
    const isAuthenticated = UsersService.isAuthenticated();
    const isAdmin = UsersService.isAdmin();
    const isUser  = UsersService.isUser();
    const isHdfc = UsersService.isHdfc();
    const isIcici = UsersService.isIcici();
    const isMis = UsersService.isMis();


    const handleLogout = () => {
        const confirmDelete = window.confirm('Are you sure you want to logout this user?');
        if (confirmDelete) {
            UsersService.logout();
        }
    };


    return (
        <nav>
            <ul>
                {/* {!isAuthenticated && <li><Link to="/">EMPLOYEE MANAGEMENT SERVICES</Link></li>} */}
                <div className='navbar-span'  style={{ color: 'white' }}>
                {!isAuthenticated && <span>EMPLOYEE MANAGEMENT SERVICES</span>}
                </div>
                {isAuthenticated && <li><Link to="/profile">Profile</Link></li>}
                {isAdmin && <li><Link to="/process-Selection">Assign Interview process</Link></li>}
                {isUser && <li><Link to ="/hdfcmrpage"> Manager Response</Link></li>}
                {isHdfc && <li><Link to = "/hdfcmrpage"> Manager Response</Link></li>}
                {isIcici && <li><Link to = "/icicimrpage">Manager Response</Link></li>}
                {isMis && <li><Link to = "/mispage">Manager Response</Link></li>}
                {isAuthenticated && <li><Link to="/" onClick={handleLogout}>Logout</Link></li>}
            </ul>
        </nav>
    );
}

export default Navbar;