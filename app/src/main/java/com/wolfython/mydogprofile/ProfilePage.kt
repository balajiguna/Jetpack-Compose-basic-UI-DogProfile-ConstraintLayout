package com.wolfython.mydogprofile

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ProfilePage(){
    Card(elevation = 6.dp, modifier = Modifier
        .fillMaxSize()
        .padding(
            top = 25.dp, bottom = 50.dp,
            start = 16.dp, end = 16.dp
        )
        .border(width = 2.dp, color = Color.White),
        shape = RoundedCornerShape(10.dp)) {


        ConstraintLayout {
            // getting the Reference
            val (image,nameText,countryText,rowStats,buttonStat) = createRefs()
            //fonts
            val myFontFamily = FontFamily(
                Font(R.font.poppins_semibold, FontWeight.SemiBold),
                Font(R.font.poppins_regular, FontWeight.Light))
            //String value
            val petdetails:String = "The Chocolate Lab is a friendly, confident and loving dog. And one that has a huge appeal as a pet. But a recent study has thrown doubt as to whether this cute color is as healthy as his yellow and black Lab cousins. While it’s true that this study suggested chocolate Labs might have a shorter lifespan and be more prone to health problems, the situation isn’t as clear cut as you might imagine. And there is a lot more to the chocolate Lab than just fur-deep."
                 // GuideLine to make a little space in Top
              val guideLine = createGuidelineFromTop(0.1f)


            //ImageView
            Image(painter = painterResource(id = R.drawable.profile),
                contentDescription = "dog", modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .border(
                        width = 2.dp,
                        color = Color.Black,
                        shape = CircleShape
                    )
                    .constrainAs(image) {
                        //linking constraints
                        top.linkTo(guideLine)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                contentScale = ContentScale.Crop)

          //TextViews
            Text(text = "Bhairavi", fontSize = 16.sp,
                fontFamily = myFontFamily,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.constrainAs(nameText){
               //linking the Constraints
                    //start means left
                    //end means right
                top.linkTo(image.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })

            Text(text = "India", fontSize = 16.sp,
                fontFamily = myFontFamily,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.constrainAs(countryText){
                    //linking the Constraints
                    //start means left
                    //end means right
                top.linkTo(nameText.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })


            Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .constrainAs(rowStats) {
                    //linking the Constraints
                    top.linkTo(countryText.bottom)
                }) {


                ProfileStats(title = "Age", count ="25 Months" )
                ProfileStats(title = "Gender", count ="Female" )
                ProfileStats(title = "Color", count ="Chocolate" )
            }


            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .constrainAs(buttonStat) {
                        top.linkTo(rowStats.bottom)
                    }


            ) {

//                Button(onClick = { /*TODO*/ }) {
//                    Text(text = "Follow user")
//
//                }
//                Button(onClick = { /*TODO*/ }) {
//                    Text(text = "Message")
//
//                }

                //TextView for details
                  Text(text = petdetails, fontFamily = myFontFamily, fontWeight = FontWeight.Light)

            }
        }
    }


}


@Composable
fun ProfileStats(title: String,count: String){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = title, fontSize = 18.sp, color = Color.Black, fontWeight = FontWeight.Bold)

        Text(text = count, fontSize = 16.sp, color = Color.Black)
    }

}
//for Previews
@Preview(showBackground = true)
@Composable
fun ProfilePagePreview () {
    ProfilePage()
}