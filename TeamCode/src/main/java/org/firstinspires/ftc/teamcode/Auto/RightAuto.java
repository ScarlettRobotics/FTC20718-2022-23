package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Core.*;
import org.firstinspires.ftc.teamcode.Core.CV.*;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Right Auto", group="Auto")

public class RightAuto extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);

    protected DualMotorDrive drive;
    protected ClawCore claw;
    protected SlideCore slide;
    protected WebcamCore webcam;
    protected CameraServoCore cameraServo;

    protected AutoEventHandler autoEventHandler;
    protected SleeveDetector sleeveDetector;

    @Override
    public void runOpMode() {
        initialize();

        waitForStart();
        runtime.reset();

        sleeveDetector.updateSleevePos(webcam.pipeline.getHsvFilterPink(), webcam.pipeline.getHsvFilterGreen(), webcam.pipeline.getHsvFilterOrange());

        // run until the end of match (driver pressed STOP)
        while(opModeIsActive()) {
            //Constantly Ran
            drive.update();
            addTelemetry(telemetry);
            telemetry.update();

            if (autoEventHandler.actionOccurred(0, runtime.time())) {
                claw.close();
            }

            //proceed forward
            if (autoEventHandler.actionOccurred(1, runtime.time())) {
                drive.moveInches(-55, -45);
            }

            //raise arm
            if(autoEventHandler.actionOccurred(2, runtime.time())){
                slide.slideManual(0.85);
                //turn left to post
                drive.moveInches(0.4, -0.4);
            }

            //forward to post
            if(autoEventHandler.actionOccurred(3, runtime.time())) {
                drive.moveInches(-14, -14);
            }

            //slide down slightly
            if(autoEventHandler.actionOccurred(4, runtime.time())) {
                slide.slideManual(-0.25);
            }

            //Drop Cone
            if(autoEventHandler.actionOccurred(5, runtime.time())){
                claw.open();
            }

            // Raise claw
            if(autoEventHandler.actionOccurred(6, runtime.time())){
                slide.slideManual(0.85);
            }


            //Reverse
            if(autoEventHandler.actionOccurred(7,runtime.time())) {
                drive.moveInches(14, 14);
            }

            if(autoEventHandler.actionOccurred(8, runtime.time())){
                drive.moveInches(5, -5);
                claw.close();
            }

            //Lower slide
            if(autoEventHandler.actionOccurred(9,runtime.time())){
                slide.slideManual(-0.5);
            }
            if(autoEventHandler.actionOccurred(10,runtime.time())){
                slide.slideManual(-0.4);
            }

            if(autoEventHandler.actionOccurred(11, runtime.time())){
                slide.slideManual(0);
            }

            //PARK

            //switch state based on cam
            switch(sleeveDetector.getSleevePos()){
                case 1:
                    if(autoEventHandler.actionOccurred(12, runtime.time())){
                        drive.moveInches(20,20);
                    }
                case 2:
                    if(autoEventHandler.actionOccurred(12, runtime.time())){
                        drive.moveInches(2,2);
                    }
                case 3:
                    if(autoEventHandler.actionOccurred(12, runtime.time())){
                        drive.moveInches(-10,-10);
                    }
                case 0:
                    if(autoEventHandler.actionOccurred(12, runtime.time())){

                    }
            }
            //park 1

            //park 2

            //park 3

            //fin - burn rest of time standing still
        }


    }

    /** Runs everything related to class setup */
    private void initialize() {
        // Define classes
        drive = new DualMotorDrive(hardwareMap);
        claw = new ClawCore(hardwareMap);
        slide = new SlideCore(hardwareMap);

        webcam = new WebcamCore(hardwareMap);

        sleeveDetector = new SleeveDetector();

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        //AutoEventHandler
        autoEventHandler = new AutoEventHandler();
        autoEventHandler.addDetectionTime(0);
        autoEventHandler.addDetectionTime(500);
        autoEventHandler.addDetectionTime(6000);
        autoEventHandler.addDetectionTime(10000);
        autoEventHandler.addDetectionTime(15000);
        autoEventHandler.addDetectionTime(17000);
        autoEventHandler.addDetectionTime(18000);
        autoEventHandler.addDetectionTime(20000);
        autoEventHandler.addDetectionTime(22000);
        autoEventHandler.addDetectionTime(23500);
        autoEventHandler.addDetectionTime(25000);
        autoEventHandler.addDetectionTime(27500);
        autoEventHandler.addDetectionTime(29000);
    }

    private void addTelemetry(Telemetry telemetry) {
        telemetry.addData("FTC Team #", "20718");
        telemetry.addData("Elapsed time", "%4.2f", runtime.time());
        drive.telemetry(telemetry);
        sleeveDetector.telemetry(telemetry);
        autoEventHandler.telemetry(telemetry);
        telemetry.update();
    }
}