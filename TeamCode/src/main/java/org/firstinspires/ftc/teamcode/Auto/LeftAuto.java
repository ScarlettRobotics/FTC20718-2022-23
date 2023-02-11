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
                drive.update();
                // Telemetry
                addTelemetry(telemetry);
                telemetry.update();

                claw.close();
                sleep(500);
                //proceed forward
                drive.moveInches(52,52);
                drive.update();
                drive.telemetry(telemetry);
                telemetry.update();


                sleep(1000);

                //raise arm
                slide.slideManual(1);
                //turn right to post
                drive.moveInches(-5, 5);
                drive.update();

                //forward to post
                sleep(500);
                drive.moveInches(10,10);
                drive.update();

                //slide down slightly
                sleep(5000);
                slide.slideManual(-0.25);

                sleep(2000);
                //Drop Cone
                claw.open();

                sleep(1000);
                // Raise claw
                slide.slideManual(1);

                sleep(2000);

                //Reverse
                drive.moveInches(-10,-10);
                drive.update();
                sleep(500);
                drive.moveInches(5,-5);
                drive.update();

                //Lower slide
                slide.slideManual(-1);
                sleep(2500);
                slide.slideManual(0);

                //PARK

                //switch state based on cam
                //park 1

                //park 2

                //park 3

                //fin - burn rest of time standing still


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
    }

    private void addTelemetry(Telemetry telemetry) {
        telemetry.addData("FTC Team #", "20718");
        telemetry.addData("Elapsed time", "%4.2f", runtime.time());
        drive.telemetry(telemetry);
        sleeveDetector.telemetry(telemetry);
        telemetry.update();
    }
}
