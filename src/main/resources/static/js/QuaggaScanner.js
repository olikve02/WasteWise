
Quagga.init({
    inputStream : {
        name : "Live",
        type : "LiveStream",
        target: document.querySelector('#video'),    // Camera live stream
        constraints: { //mulig vi må fjerne dette om det kødder til nokke
            width: 350
        },
    },
    decoder : {
        readers : ["ean_reader"]    // Define the barcode format to be read
    }
}, function(err) {
    if (err) {
        console.log(err);
        return;
    }
    console.log("Initialization finished. Ready to start");
    Quagga.start();    // Start Quagga
});
var lastDetectedBarcode = null;
var detectionCount = 0;
var requiredDetectionCount = 6;
// Quagga event listener for barcode detection
Quagga.onDetected(function(result) {

    var code = result.codeResult.code;
    // If the detected barcode is the same as the last one, increment the detection count
    if (code === lastDetectedBarcode) {
        detectionCount++;

        // If the required number of detections is reached, consider it as the correct code
        if (detectionCount >= requiredDetectionCount) {
            document.getElementById('result').textContent = 'Barcode detected: ' + code;

           document.getElementById("strekkode").value = code;
            // Reset detection count and last detected barcode
            detectionCount = 0;
            lastDetectedBarcode = null;
        }
    } else {
        // If a new barcode is detected, reset detection count and update last detected barcode
        detectionCount = 1;
        lastDetectedBarcode = code;
    }
});

