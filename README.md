Jetpack Compose
Column 
Row
Remember
// remember is a tool in Jetpack Compose that helps your app remember a value
var counter = remember { mutableStateOf(0) }

    var incrementCounter = {
        Log.d("MainScreen", "Increment Counter Value is ${counter.value}")
        counter.value += 1
    }

    var decrementCounter = {
        Log.d("MainScreen", "Increment Counter Value is ${counter.value}")
        counter.value -= 1
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
        ) {
            Button(onClick = { decrementCounter.invoke() }, modifier = Modifier.padding(5.dp)) {
                Text(text = "Decrement")
            }
            Text(text = "${counter.value}")

            Button(onClick = { incrementCounter.invoke() }) {
                Text(text = "Increment")
            }
        }
    }
Remembersavable
// It Will Hold the values in Configuration Changes 
    var counter by rememberSaveable { mutableStateOf(0) }
    
mutablestateOf
