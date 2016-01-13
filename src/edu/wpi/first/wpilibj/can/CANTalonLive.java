package edu.wpi.first.wpilibj.can;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;
import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.tables.ITableListener;

/**
 * @author Bryan
 * A class that adds LiveWindow capabilities to CANTalon
 */
public class CANTalonLive extends CANTalon implements LiveWindowSendable {
	
	private ITable m_table;
	private ITableListener m_table_listener;
	
	public CANTalonLive(int deviceNumber) {
		super(deviceNumber);
	}
	
	public CANTalonLive(int deviceNumber,int controlPeriodMs) {
		super(deviceNumber, controlPeriodMs);
	}

	@Override
	public void initTable(ITable subtable) {
		m_table = subtable;
		updateTable();
	}

	@Override
	public ITable getTable() {
		return m_table;
	}

	@Override
	public String getSmartDashboardType() {
		return "Can Talon";
	}

	@Override
	public void updateTable() {
		if (m_table != null) {
			m_table.putNumber("Value", getSpeed());
		}
	}

	@Override
	public void startLiveWindowMode() {
		set(0);
		m_table_listener = new ITableListener() {
			
			@Override
			public void valueChanged(ITable source, String key, Object value, boolean isNew) {
				set(((Double) value).doubleValue()); //casts to Double then gets value. Clever
			}
		};
		m_table.addTableListener("Value",  m_table_listener, true);
		
	}

	@Override
	public void stopLiveWindowMode() {
		set(0);
		
		//it says this is broken. *shrug* whatever
		m_table.removeTableListener(m_table_listener);
	}

}
