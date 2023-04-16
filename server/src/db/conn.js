const mongoose = require("mongoose");

mongoose.connect("mongodb+srv://url",
{
    useNewUrlParser:true,
    useUnifiedTopology:true,
}
).then(()=>{
    console.log("BOOM CONNECTED 🔥🔥🔥🔥");
}).catch((e)=>{
    console.log("NOT CONNECTED :( ");
})