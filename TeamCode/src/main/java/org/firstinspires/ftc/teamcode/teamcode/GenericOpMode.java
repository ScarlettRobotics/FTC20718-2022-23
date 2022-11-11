package org.firstinspires.ftc.teamcode.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


/** GenericOpMode
 * Author(s): @Samuel-Trepac
 * Generic OpMode to be used as the starting point for the robot code. Ideally, this should be modified and
 * eventually deprecated.
 */
public class GenericOpMode extends OpMode {


    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    private DcMotor centerDrive = null;

    @Override
    public void init() {
        telemetry.addData("STATUS:", "ENABLED");

        //Here you will want to initialize basic objects for the robot (i.e drive train).
        leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        centerDrive = hardwareMap.get(DcMotor.class, "centerDrive");

        //for now because I am lazy I will call loop within initialization because that's a good and smart idea.
        //obviously change this. This is bad style, this is bad code.
        loop();

    }

    @Override
    public void loop() {



    }
}
