package org.firstinspires.ftc.teamcode.Auto;

/** MOVEMENTS TO MAKE:
 * adjust to high junction
 * strafe 7 in
 * move 52 in forward
 * strafe 12 in
 * CASES:
 *  1: strafe 12 in/36 in
 *  2: strafe 12 in
 *  3: strafe 36 in/12 in */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Core.*;
import org.firstinspires.ftc.teamcode.Core.CV.*;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Left Auto", group="Auto")

public class LeftAuto extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);

    private AutoEventHandler autoEventHandler;
    protected DualMotorDrive drive;
    protected ClawCore claw;
    protected SlideCore slide;
    protected WebcamCore webcam;

    protected SleeveDetector sleeveDetector;

    @Override
    public void runOpMode() {
        initialize();

        waitForStart();
        runtime.reset();

        int sleevePos = sleeveDetector.updateSleevePos();

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
                drive.moveInches(-100, -100);
            }

            //raise arm
            if(autoEventHandler.actionOccurred(2, runtime.time())){
                slide.slideManual(0.85);
                //turn right to post
                drive.moveInches(5, -5);
            }

            //forward to post
            if(autoEventHandler.actionOccurred(3, runtime.time())) {
                drive.moveInches(-10, -10);
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
                drive.moveInches(10, 10);
            }
            if(autoEventHandler.actionOccurred(8, runtime.time())){
                drive.moveInches(-5, 5);
            }

            //Lower slide
            if(autoEventHandler.actionOccurred(9,runtime.time())){
                slide.slideManual(-0.75);
            }
            if(autoEventHandler.actionOccurred(10,runtime.time())){
                slide.slideManual(-0.5);
            }

            if(autoEventHandler.actionOccurred(11, runtime.time())){
                slide.slideManual(0);
            }

            //PARK

            //switch state based on cam
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
        autoEventHandler.addDetectionTime(1000);
        autoEventHandler.addDetectionTime(10000);
        autoEventHandler.addDetectionTime(15000);
        autoEventHandler.addDetectionTime(17000);
        autoEventHandler.addDetectionTime(18000);
        autoEventHandler.addDetectionTime(20000);
        autoEventHandler.addDetectionTime(20500);
        autoEventHandler.addDetectionTime(21000);
        autoEventHandler.addDetectionTime(22000);
        autoEventHandler.addDetectionTime(25500);
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
