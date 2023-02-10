package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.Core.ClawCore;
import org.firstinspires.ftc.teamcode.Core.DualMotorDrive;
import org.firstinspires.ftc.teamcode.Core.SlideCore;

@Autonomous(name = "ExampleAuto", group = "Auto")
public class AutoEx extends LinearOpMode {

    private DualMotorDrive drive;
    private ClawCore claw;
    private SlideCore slide;
    private ElapsedTime runtime = new ElapsedTime();

    //Vars
    //Motor Speeds
    private double leftMotor = 0;
    private double rightMotor = 0;

    @Override
    public void runOpMode() {
        telemetry.addData("Auto MODE: ", "Auto example");
        telemetry.addData("FTC Team #", "20718");
        telemetry.update();

        //Init
        drive = new DualMotorDrive(hardwareMap);
        claw = new ClawCore(hardwareMap);
        slide = new SlideCore(hardwareMap);

        waitForStart();

        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() <= 0.5)) {
            leftMotor = 0.5;
            rightMotor = 0.75;
            drive.setMoveVelocity(leftMotor, rightMotor);
            drive.telemetry(telemetry);
            telemetry.update();
        }
        while (opModeIsActive() && (runtime.seconds() <= 1)) {
            leftMotor = 1;
            rightMotor = 1;
            drive.setMoveVelocity(leftMotor, rightMotor);
            drive.telemetry(telemetry);
            telemetry.update();
        }
        leftMotor = 0;
        rightMotor = 0;
        drive.setMoveVelocity(leftMotor, rightMotor);
        drive.telemetry(telemetry);
        telemetry.update();
    }
}

