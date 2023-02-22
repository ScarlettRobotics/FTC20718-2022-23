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
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Core.AutoEventHandler;
import org.firstinspires.ftc.teamcode.Core.CV.SleeveDetector;
import org.firstinspires.ftc.teamcode.Core.CV.WebcamCore;
import org.firstinspires.ftc.teamcode.Core.ClawCore;
import org.firstinspires.ftc.teamcode.Core.DualMotorDrive;
import org.firstinspires.ftc.teamcode.Core.SlideCore;

@Autonomous(name="Forward Auto", group="Auto")

public class ForwardAuto extends LinearOpMode {
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
        autoEventHandler.addDetectionTime(27750);
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
