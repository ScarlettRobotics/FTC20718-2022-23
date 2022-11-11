package org.firstinspires.ftc.teamcode.Drive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class TankDrive extends OpMode {
    TriMotorDrive drive = new TriMotorDrive;



    @Override
    public void init() {
            drive.init(hardwareMap);

    }

    @Override
    public void loop() {

    }
}
