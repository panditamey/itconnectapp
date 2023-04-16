const express = require("express");
const mongoose = require("mongoose");
const nodemailer = require("nodemailer");
const crypto = require("crypto");
const async = require("hbs/lib/async");
const app = express();
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

const port = process.env.PORT || 3001
require("./db/conn")
const User = require("./models/user");


app.post("/signup", async (req, res) => {
    try {
        var otp = crypto.randomInt(100000, 999999);

        const name = req.body.name;
        const email = req.body.email;
        const password = otp;

        var checkUser ;

        const useremail = await User.findOne({ email: email });
        console.log(useremail);

        if (useremail !== null) {
            console.log(useremail);
            res.send(JSON.stringify(0));
            
        }else {
            let transporter = nodemailer.createTransport({
                service: 'gmail',
                auth: {
                    user: 'email',
                    pass: 'pass'
                }
            });

            let mailOptions = {
                from: 'panditamey-inft@atharvacoe.ac.in',
                to: email,
                subject: 'Hey ' + name + ' Your Password',
                text: 'Your Password is ' + otp
            }

            transporter.sendMail(mailOptions, function (err, data) {
                if (err) {
                    console.log('Error');
                } else {
                    console.log("Password Sent !")
                }
            })


            console.log(name)
            console.log(email)
            console.log(password)

            const registerUser = new User({
                name: name,
                email: email,
                password: password
            })

            const data = await registerUser.save();
            res.send(JSON.stringify(1));

        }




    } catch (error) {
        res.send(JSON.stringify(0));

        // res.status(400).send("0");

    }
});


app.post("/login", async (req, res) => {
    try {


        const email = req.body.email;
        const password = req.body.password;


        console.log(email)
        console.log(password)

        const useremail = await User.findOne({ email: email });

        if (useremail.password === password) {
            // res.send("true");
            res.send(JSON.stringify(1));

        } else {

            // res.status(400).send("0");
            // res.send("false");
            res.send(JSON.stringify(0));

        }


    } catch (error) {

        // res.status(400).send("0");
        res.send("0");

    }
});

app.listen(port, () => {

    console.log("BOOM SERVER RUNS 🔥🔥🔥🔥");
})

