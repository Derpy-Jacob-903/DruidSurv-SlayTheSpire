package druidsurv.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.powers.WeakBloonPower;

import static druidsurv.ModFile.makeID;

public class WeakGas extends AbstractEasyCard {
    public final static String ID = makeID("WeakGas");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public WeakGas() {
        super(ID, 1, CardType.SKILL, CardRarity.RARE, CardTarget.SELF);
        baseDamage = 60;
        baseBlock = 6;
        tags.add(druidsurv.cards.cardvars.CardTags.BLOON);
        tags.add(druidsurv.cards.cardvars.CardTags.LARGE);
        this.exhaust = true;
        setBackgroundTexture("druidsurvResources/images/512/bloon_skill.png", "druidsurvResources/images/1024/bloon_skill.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new ApplyPowerAction(p, p, (AbstractPower)new WeakBloonPower(p, damage), damage, true, AbstractGameAction.AttackEffect.NONE));
        blck();
    }

    @Override
    public void upp()
    {
        upgradeDamage(7);
        upgradeBlock(3);
    }
}