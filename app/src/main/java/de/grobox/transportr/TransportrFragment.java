/*
 *    Transportr
 *
 *    Copyright (c) 2013 - 2017 Torsten Grote
 *
 *    This program is Free Software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as
 *    published by the Free Software Foundation, either version 3 of the
 *    License, or (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package de.grobox.transportr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import javax.annotation.ParametersAreNonnullByDefault;

import de.grobox.transportr.AppComponent;
import de.grobox.transportr.TransportrActivity;
import de.grobox.transportr.TransportrApplication;


@ParametersAreNonnullByDefault
public abstract class TransportrFragment extends Fragment {

	protected AppComponent getComponent() {
		if (getActivity() == null) throw new IllegalStateException();
		return ((TransportrApplication) getActivity().getApplication()).getComponent();
	}

	protected void runOnUiThread(final Runnable task) {
		if (getActivity() == null) throw new IllegalStateException();
		getActivity().runOnUiThread(task);
	}

	protected void setUpToolbar(Toolbar toolbar) {
		if (getActivity() == null) throw new IllegalStateException();
		((TransportrActivity) getActivity()).setSupportActionBar(toolbar);
		ActionBar ab = ((TransportrActivity) getActivity()).getSupportActionBar();
		if (ab != null) {
			ab.setDisplayShowHomeEnabled(true);
			ab.setDisplayHomeAsUpEnabled(true);
			ab.setDisplayShowCustomEnabled(true);
			ab.setDisplayShowTitleEnabled(false);
		}
	}

	@NonNull
	@Override
	public Context getContext() {
		if (super.getContext() == null) throw new IllegalStateException();
		return super.getContext();
	}

}
