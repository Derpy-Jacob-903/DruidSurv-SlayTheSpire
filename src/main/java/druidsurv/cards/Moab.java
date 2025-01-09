package druidsurv.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.cards.cardvars.CardTags;
import druidsurv.powers.fourdelaybloon;
import druidsurv.powers.onedelaybloon;

import static druidsurv.ModFile.makeID;

public class Moab extends AbstractEasyCard {
    public final static String ID = makeID("MOAB");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public Moab() {
        super(ID, 1, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseDamage = 100;
        baseBlock = 6;
        tags.add(druidsurv.cards.cardvars.CardTags.BLOON);
        tags.add(druidsurv.cards.cardvars.CardTags.LARGE);
        this.exhaust = true;
        setBackgroundTexture("druidsurvResources/images/512/bloon_attack.png", "druidsurvResources/images/1024/bloon_attack.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new ApplyPowerAction(m, p, (AbstractPower)new fourdelaybloon(m, damage), damage, true, AbstractGameAction.AttackEffect.NONE));
        blck();
    }

    @Override
    public void upp()
    {
        upgradeDamage(7);
        upgradeBlock(3);
    }
}