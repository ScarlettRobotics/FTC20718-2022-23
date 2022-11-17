package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Core.ClawCore;
import org.firstinspires.ftc.teamcode.Core.DualMotorDrive;
import org.firstinspires.ftc.teamcode.Core.SlideCore;

@Autonomous(name = "ExampleAuto", group = "Auto")
public class AutoEx extends LinearOpMode{

    private DualMotorDrive drive;
    private ClawCore claw;
    private SlideCore slide;
    private ElapsedTime runtime = new ElapsedTime();

    //Vars
    //Motor Speeds
    private double leftMotor = 0;
    private double rightMotor = 00;
    @Override
    public void runOpMode() {
        telemetry.addData("Auto MODE: ", "Auto example");
        telemetry.addData("FTC Team #", "20718");
        telemetry.update();

        //Init
        drive = new DualMotorDrive(hardwareMap);
        claw = new ClawCore(hardwareMap);
        slide = new SlideCore(hardwareMap);

        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() <= 3.0)) {
            leftMotor  = 0.5;
            rightMotor = 0.5;
            telemetry.addData("Left Power:", leftMotor);
            telemetry.addData("Right Stick:", rightMotor);
            telemetry.update();
            drive.setPowers(leftMotor, rightMotor);
        }
        leftMotor = 0;
        rightMotor = 0;
        drive.setPowers(leftMotor, rightMotor);
        telemetry.addData("Left Power:", leftMotor);
        telemetry.addData("Right Stick:", rightMotor);
        telemetry.update();
    }
}

