import {useState} from "react";
import {useNavigate} from "react-router-dom";
import axios from "axios";

const SimpleE_CommerceLogin = () => {
    const [userName, setUserName] = useState('')
    const [passWord,setPassWord] = useState('')
    const [phoneNumber, setPhoneNumber] = useState(0)
    const [message, setMessage] = useState('')

     const navigate = useNavigate()
    const HandleLogin = async (event) => {
        event.preventDefault()
        try {
            const response = await axios.post('http://localhost:8089/authentication/authenticatePeople', {
                userName: userName,
                passWord: passWord,
                phoneNumber:phoneNumber
            })
            const savetoken = response.headers["authorization"]
            if(savetoken){
                localStorage.setItem('savetoken', savetoken)
            }else{
                alert("No token received")
            }if ((response.data)){
                setMessage("Authentication successfull")
                  setTimeout(() => {navigate("/E_CommerceDashboard")
                  }  ,1000);
            }
        }
        catch(error){
            if(error.message == "Request failed with status code 401"){
                setMessage("Authentication failed")
            }
        }
    }
    return(
        <form onSubmit={HandleLogin}>
            <div>
                <label>User Name:</label>
                <input
                    type="text"
                    value={userName}
                    onChange={(e) => setUserName(e.target.value)}
                />
            </div>
            <div>
                <label>Pass Word:</label>
                <input
                    type="text"
                    value={passWord}
                    onChange={(e) => setPassWord(e.target.value)}
                />
            </div>
            <div>
                <label>Phone Number:</label>
                <input
                    type="text"
                    value={phoneNumber}
                    onChange={(e) => setPhoneNumber(e.target.value)}
                />
            </div>
            <div>
                <button type="submit">Login</button>
                <p>{message}</p>
            </div>
        </form>
    )
}

export default SimpleE_CommerceLogin