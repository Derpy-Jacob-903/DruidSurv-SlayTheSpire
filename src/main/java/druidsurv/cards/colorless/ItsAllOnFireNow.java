package druidsurv.cards.colorless;

import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.PersistFields;
import com.evacipated.cardcrawl.mod.stslib.variables.ExhaustiveVariable;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.orbs.Lightning;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.cards.AbstractPowerCostCard;

import static druidsurv.ModFile.makeID;

public class ItsAllOnFireNow extends AbstractEasyCard {
    public final static String ID = makeID("ItIsAllOnFireNow");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public ItsAllOnFireNow() {
        super(ID, 1, CardType.ATTACK, CardRarity.BASIC, CardTarget.ALL_ENEMY, "HeartOfThunder");
        baseDamage = 10;
        this.showEvokeValue = true;
        this.showEvokeOrbCount = 1;
        PersistFields.setBaseValue(this, 2);
        ExhaustiveVariable.setBaseValue(this, 2);
        baseMagicNumber = magicNumber = 1;
        isMultiDamage = true;
        //setOrbTexture("druidsurvResources/images/512/bloontonium.png", "druidsurvResources/images/1024/bloontonium.png");
        //setBackgroundTexture("druidsurvResources/images/512/hero_attack.png", "druidsurvResources/images/1024/hero_attack.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {


    }

    @Override
    public void upp() {
        upgradeBaseCost(1);
    }
}