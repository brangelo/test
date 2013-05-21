package com.fhoster.test.server;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.fhoster.livetable.servant.LiveTableServant;
import com.fhoster.livetable.servant.LivetableItem;
import com.fhoster.livetable.servant.configurator.ColumnPositionConfiguration;
import com.fhoster.livetable.servant.configurator.ColumnWidthConfiguration;
import com.fhoster.livetable.servant.configurator.GroupingColumnConfiguration;
import com.fhoster.livetable.servant.configurator.HiddenColumnConfiguration;
import com.fhoster.livetable.servant.configurator.LivetableAdvancedExpression;
import com.fhoster.livetable.servant.configurator.LivetableBasicExpression;
import com.fhoster.livetable.servant.configurator.LivetableComputedColumn;
import com.fhoster.livetable.servant.configurator.LivetableServantConfigurator;
import com.fhoster.livetable.servant.configurator.OrderingColumnConfiguration;
import com.fhoster.livetable.servletInterface.rows.AV_Boolean;
import com.fhoster.livetable.servletInterface.rows.AV_Date;
import com.fhoster.livetable.servletInterface.rows.AV_Datetime;
import com.fhoster.livetable.servletInterface.rows.AV_Double;
import com.fhoster.livetable.servletInterface.rows.AV_Image;
import com.fhoster.livetable.servletInterface.rows.AV_Integer;
import com.fhoster.livetable.servletInterface.rows.AV_Link;
import com.fhoster.livetable.servletInterface.rows.AV_Long;
import com.fhoster.livetable.servletInterface.rows.AV_String;
import com.fhoster.livetable.servletInterface.rows.AV_Time;
import com.fhoster.livetable.servletInterface.rows.AV_Year;
import com.fhoster.livetable.servletInterface.rows.LivetableAttribute;
import com.fhoster.livetable.servletInterface.rows.LivetableAttributeType;
import com.fhoster.livetable.servletInterface.settings.FeatureSet;
import com.fhoster.livetable.servletInterface.settings.FeatureType;
import com.fhoster.livetable.servletInterface.settings.OrderingType;

public class LivetableServantFactory {

    public static int progressiveId = 0;

    public static LiveTableServant getLivetableTestServant() {
        final LiveTableServant testServant;
        final ArrayList<LivetableAttribute> attributeList = new ArrayList<LivetableAttribute>();
        final LivetableAttribute ABC = new LivetableAttribute("A.B.C", LivetableAttributeType.STRING);
        final LivetableAttribute ABD = new LivetableAttribute("A.B.D", LivetableAttributeType.STRING);
        final LivetableAttribute BE = new LivetableAttribute("B.E", LivetableAttributeType.STRING);
        final LivetableAttribute s = new LivetableAttribute("s", LivetableAttributeType.STRING);
        final LivetableAttribute i = new LivetableAttribute("i", LivetableAttributeType.INTEGER);
        final LivetableAttribute l = new LivetableAttribute("l", LivetableAttributeType.LONG);
        final LivetableAttribute r = new LivetableAttribute("r", LivetableAttributeType.DOUBLE);
        final LivetableAttribute b = new LivetableAttribute("b", LivetableAttributeType.BOOLEAN);
        final LivetableAttribute d = new LivetableAttribute("d", LivetableAttributeType.DATE);
        final LivetableAttribute dt = new LivetableAttribute("dt", LivetableAttributeType.DATETIME);
        final LivetableAttribute t = new LivetableAttribute("t", LivetableAttributeType.TIME);
        final LivetableAttribute year = new LivetableAttribute("YEAR", LivetableAttributeType.YEAR);
        attributeList.add(ABC);
        attributeList.add(ABD);
        attributeList.add(BE);
        attributeList.add(s);
        attributeList.add(i);
        attributeList.add(l);
        attributeList.add(r);
        attributeList.add(b);
        attributeList.add(d);
        attributeList.add(dt);
        attributeList.add(t);
        attributeList.add(year);

        final FeatureSet features = new FeatureSet();

        features.addFeature(FeatureType.COLUMN_COLLAPSE_EXPAND);
        features.addFeature(FeatureType.COLUMN_HIDE_SHOW);
        features.addFeature(FeatureType.COLUMN_HIGHLIGHT);
        features.addFeature(FeatureType.COLUMN_RESIZE);
        features.addFeature(FeatureType.COLUMN_SHIFT);

        features.addFeature(FeatureType.ROW_FILTER);

        features.addFeature(FeatureType.ROW_GROUP);
        features.addFeature(FeatureType.ROW_SORT);

        features.addFeature(FeatureType.ROW_HIGHLIGHT);
        features.addFeature(FeatureType.ROW_SELECT_FREE);
        features.addFeature(FeatureType.AUTO_HORIZONTAL_SCROLLBAR);
        features.addFeature(FeatureType.DATAGRID_RESIZE);
        features.addFeature(FeatureType.TABLE_COLLAPSE_EXPAND);
        features.addFeature(FeatureType.GLOBAL_STATISTICS);
        features.addFeature(FeatureType.ROW_SEARCH);
        features.addFeature(FeatureType.COMPUTED_COLUMNS);

        final ArrayList<LivetableItem> itemList = new ArrayList<LivetableItem>();
        final LivetableItem item1 = new LivetableItem(1);
        item1.setAttributeValue("A.B.C", new AV_String("ABC valore1"));
        item1.setAttributeValue("A.B.D", new AV_String("ABD valore1"));
        item1.setAttributeValue("B.E", new AV_String("BE valore1"));
        item1.setAttributeValue("s", new AV_String("s valore1"));
        item1.setAttributeValue("i", new AV_Integer(Integer.MAX_VALUE));
        item1.setAttributeValue("l", new AV_Long(134567L));
        item1.setAttributeValue("r", new AV_Double(2000.3333));
        item1.setAttributeValue("b", new AV_Boolean(true));
        item1.setAttributeValue("d", new AV_Date(1998, 3, 12));
        item1.setAttributeValue("dt", new AV_Datetime(Calendar.getInstance().getTime()));
        item1.setAttributeValue("t", new AV_Time(12, 21, 44));
        item1.setAttributeValue("YEAR", new AV_Year(1960));

        final LivetableItem item2 = new LivetableItem(2);
        item2.setAttributeValue("A.B.C", new AV_String("ABC valore2"));
        item2.setAttributeValue("A.B.D", new AV_String("ABD valore2"));
        item2.setAttributeValue("B.E", new AV_String("BE valore2"));
        item2.setAttributeValue("s", new AV_String("s valore2"));
        item2.setAttributeValue("i", new AV_Integer(Integer.MIN_VALUE));
        item2.setAttributeValue("l", new AV_Long(1l));
        item2.setAttributeValue("r", new AV_Double(4.33));
        item2.setAttributeValue("b", new AV_Boolean(true));
        item2.setAttributeValue("d", new AV_Date(2001, 1, 11));
        item2.setAttributeValue("dt", new AV_Datetime(Calendar.getInstance().getTime()));
        item2.setAttributeValue("t", new AV_Time(22, 41, 4));
        item2.setAttributeValue("YEAR", new AV_Year(1980));

        itemList.add(item1);
        itemList.add(item2);

        testServant = new LiveTableServant(attributeList, itemList, features);

        final LivetableServantConfigurator configurator = new LivetableServantConfigurator();

        /* add valid/invalid filters */
        final List<LivetableBasicExpression> basExp = new ArrayList<LivetableBasicExpression>();
        final List<LivetableAdvancedExpression> advExp = new ArrayList<LivetableAdvancedExpression>();
        final LivetableAdvancedExpression ex = new LivetableAdvancedExpression("Name == \"Pippo\" ");
        advExp.add(ex);
        configurator.setAdvancedFilterExpressions(advExp);
        configurator.setBasicFilterExpressions(basExp);

        /* add invalid computed columns */
        final LivetableComputedColumn lcc = new LivetableComputedColumn("test", "invalid");
        lcc.setChecked(true);
        final List<LivetableComputedColumn> computedColumns = new ArrayList<LivetableComputedColumn>();
        computedColumns.add(lcc);

        configurator.setComputedColumns(computedColumns);

        final List<GroupingColumnConfiguration> groupingColumns = new ArrayList<GroupingColumnConfiguration>();
        groupingColumns.add(new GroupingColumnConfiguration("A.B.C", OrderingType.ASCENDING));
        configurator.setGroupingColumns(groupingColumns);

        final List<ColumnWidthConfiguration> columnsWidth = new ArrayList<ColumnWidthConfiguration>();
        columnsWidth.add(new ColumnWidthConfiguration("B.E", 250));
        configurator.setColumnsWidth(columnsWidth);

        final List<ColumnPositionConfiguration> columnsPositionConfiguration = new ArrayList<ColumnPositionConfiguration>();
        columnsPositionConfiguration.add(new ColumnPositionConfiguration("B.E", 1));
        configurator.setColumnsPosition(columnsPositionConfiguration);

        final List<HiddenColumnConfiguration> hiddenColumns = new ArrayList<HiddenColumnConfiguration>();
        configurator.setHiddenColumns(hiddenColumns);

        final OrderingColumnConfiguration orderingColumnConfiguration = new OrderingColumnConfiguration("B.E", OrderingType.DESCENDING);
        configurator.setOrderingColumn(orderingColumnConfiguration);

        configurator.setTableCollapsed(false);

        testServant.configure(configurator);

        return testServant;
    }

    public static LiveTableServant getLinkLivetableServant() {
        final ArrayList<LivetableAttribute> attributes = new ArrayList<LivetableAttribute>();
        final LivetableAttribute a = new LivetableAttribute("file", LivetableAttributeType.LINK);
        attributes.add(a);

        final FeatureSet features = new FeatureSet();
        features.addFeature(FeatureType.COLUMN_COLLAPSE_EXPAND);
        features.addFeature(FeatureType.COLUMN_HIDE_SHOW);
        features.addFeature(FeatureType.COLUMN_HIGHLIGHT);
        features.addFeature(FeatureType.COLUMN_RESIZE);
        features.addFeature(FeatureType.COLUMN_SHIFT);
        features.addFeature(FeatureType.ROW_FILTER);
        features.addFeature(FeatureType.ROW_GROUP);
        features.addFeature(FeatureType.ROW_SORT);
        features.addFeature(FeatureType.ROW_HIGHLIGHT);
        features.addFeature(FeatureType.ROW_SELECT_FREE);
        features.addFeature(FeatureType.AUTO_HORIZONTAL_SCROLLBAR);
        features.addFeature(FeatureType.DATAGRID_RESIZE);
        features.addFeature(FeatureType.TABLE_COLLAPSE_EXPAND);
        features.addFeature(FeatureType.GLOBAL_STATISTICS);
        features.addFeature(FeatureType.ROW_SEARCH);
        features.addFeature(FeatureType.COMPUTED_COLUMNS);

        // 2 links with same name and different links
        final ArrayList<LivetableItem> items = new ArrayList<LivetableItem>();
        final LivetableItem i1 = new LivetableItem(1);
        i1.setAttributeValue("file", new AV_Link("fhoster", "http://www.fhoster.com"));
        final LivetableItem i2 = new LivetableItem(2);
        i2.setAttributeValue("file", new AV_Link("fhoster", "http://www.robbinssports.com/images/wilson-f1005r-leather-official-ncaa-football.jpg"));
        final LivetableItem i3 = new LivetableItem(3);
        i3.setAttributeValue("file", new AV_Link("fhoster", "http://www.robbinssports.com/images/wilson-f1005r-leather-official-ncaa-football.jpg"));
        items.add(i1);
        items.add(i2);
        items.add(i3);
        return new LiveTableServant(attributes, items, features);
    }

    public static LiveTableServant getFilterLivetableTestServant() {
        final LivetableAttribute ABC = new LivetableAttribute("A.B.C", LivetableAttributeType.STRING);
        final LivetableAttribute ABD = new LivetableAttribute("A.B.D", LivetableAttributeType.LINK);
        final LivetableAttribute BE = new LivetableAttribute("B.E", LivetableAttributeType.IMAGE);
        final ArrayList<LivetableAttribute> attributeList = new ArrayList<LivetableAttribute>();
        attributeList.add(ABC);
        attributeList.add(ABD);
        attributeList.add(BE);

        final FeatureSet features = new FeatureSet();

        features.addFeature(FeatureType.COLUMN_COLLAPSE_EXPAND);
        features.addFeature(FeatureType.COLUMN_HIDE_SHOW);
        features.addFeature(FeatureType.COLUMN_HIGHLIGHT);
        features.addFeature(FeatureType.COLUMN_RESIZE);
        features.addFeature(FeatureType.COLUMN_SHIFT);

        features.addFeature(FeatureType.ROW_FILTER);

        features.addFeature(FeatureType.ROW_GROUP);
        features.addFeature(FeatureType.ROW_SORT);

        features.addFeature(FeatureType.ROW_HIGHLIGHT);
        features.addFeature(FeatureType.ROW_SELECT_FREE);
        features.addFeature(FeatureType.AUTO_HORIZONTAL_SCROLLBAR);
        features.addFeature(FeatureType.DATAGRID_RESIZE);
        features.addFeature(FeatureType.TABLE_COLLAPSE_EXPAND);
        features.addFeature(FeatureType.GLOBAL_STATISTICS);
        features.addFeature(FeatureType.ROW_SEARCH);
        features.addFeature(FeatureType.COMPUTED_COLUMNS);

        final ArrayList<LivetableItem> itemList = new ArrayList<LivetableItem>();
        final LivetableItem item1 = new LivetableItem(1);
        item1.setAttributeValue("A.B.C", new AV_String("ABC valore1"));
        item1.setAttributeValue("A.B.D", new AV_Link("ABD valore1", "http:\\ABD valore1"));
        item1.setAttributeValue("B.E", new AV_Image("BE valore1", "src:C:/BE valore1"));
        itemList.add(item1);

        final LiveTableServant testServant = new LiveTableServant(attributeList, itemList, features);
        return testServant;
    }

}
